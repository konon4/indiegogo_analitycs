package app.search;

import com.sun.media.jfxmediaimpl.MediaDisposer;
import database.Database;
import database.DatabaseTool;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import rest.IndiegogoClient;
import rest.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


import app.util.*;
import rest.models.response.IndiegogoProjectSearchResponse;
import spark.*;
import java.util.*;
import static app.Application.*;
import static app.util.RequestUtil.*;

/**
 * Created by PC on 19.03.2017.
 */
public class SearchController {

    private static final String token = //token:

    public static class Counter<T>{
        public final T obj;
        public int count;

        public Counter(T obj, int count){
            this.obj = obj;
            this.count = count;
        }
    }

    public static Route serveSearchPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.SEARCH);
    };
    public static Route TryCach = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();

//------------------------------------------------------------
        int id = 0;
        Scanner in = new Scanner(System.in);

        Database db = new Database();

        Database.Table<IndiegogoContributor> contributorsTable =
                new Database.TableBuilder<IndiegogoContributor>("contributors")
                        .setDatabase(db)
                        .build();

        Database.Table<IndiegogoProject> projectsTable =
                new Database.TableBuilder<IndiegogoProject>("projects")
                        .setDatabase(db)
                        .build();

        Database.Table<Counter<Integer>> result =
                new Database.TableBuilder<Counter<Integer>>("result")
                        .setDatabase(db)
                        .build();

        Database.Table<Counter<IndiegogoPerk>> perks =
                new Database.TableBuilder<Counter<IndiegogoPerk>>("perks")
                        .setDatabase(db)
                        .build();

        IndiegogoClient client = IndiegogoClient.getInstance(token);
//------------------------------------------------------------

        model.put("searchquery", getQuerySearch(request));



        Disposable disposable = client.search(getQuerySearch(request)).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                System.out.print(throwable.getMessage());
            }
        }).subscribe(new Consumer<IndiegogoProjectSearchResponse>() {
            @Override
            public void accept(@NonNull IndiegogoProjectSearchResponse indiegogoProjectSearchResponse) throws Exception {
//                indiegogoProjectSearchResponse.getPagination().getCurrent();
//                indiegogoProjectSearchResponse.getPagination().getNext();
                List<IndiegogoProject> projects = indiegogoProjectSearchResponse.getResponse();
                //projects.get(0).getTitle();
//                for (IndiegogoProject e : projects) {
//                    model.put("searchquery", e.getTitle());
//                }
                model.put("searchqueries", projects);
                projectsTable.addAll(projects);
            }
        });

       while (!disposable.isDisposed());


       model.put("option", getOptionSearch(request));
       System.out.println(getOptionSearch(request));

//---------------------------------------------------------------------------------------------------------------------

        if (getOptionSearch(request)!=null) {
            id = Integer.parseInt(getOptionSearch(request));


        System.out.println("Choosed id: "+Integer.toString(id));

        final int finalId = id;
        IndiegogoProject p = projectsTable
                .request((Database.TableGetQuery<IndiegogoProject>) el -> el.getId() == finalId)
                .getFirst();

        if (p != null) {
            System.out.println(p.getTitle());
            client.getContributors(id).subscribe(
                    contrubutor -> {
                        contributorsTable.addEntry(contrubutor);
                    },
                    throwable -> {
                    },
                    () -> {
                        DatabaseTool.DatabaseToolBuilder<IndiegogoContributor> builder
                                = new DatabaseTool.DatabaseToolBuilder();
                        DatabaseTool<IndiegogoContributor> process = builder.withData(contributorsTable.getAll()).build();
                        ArrayList<Counter<Integer>> processed = process
                                .collect((var1, var2) -> var1.getAmount() == var2.getAmount())
                                .reduce(var1 -> new Counter<Integer>(var1.get(0).getAmount(), var1.size()))
                                .getData();

                        result.addAll(processed);
                        result.orderBy(Comparator.comparingInt(o -> o.obj));

                        DatabaseTool<IndiegogoContributor> processPerks =
                                builder.withData(contributorsTable.getAll()).build();

                        ArrayList<Counter<IndiegogoPerk>> perksCount = processPerks
                                .map(var -> var.getPerk())
                                .collect((var1, var2) -> var1.getId() == var2.getId())
                                .reduce(var1 -> new Counter<IndiegogoPerk>(var1.get(0), var1.size()))
                                .getData();

                        perks.addAll(perksCount);

                        for (Counter<Integer> c : result.getAll()) {
                            System.out.println("Amount: " + Integer.toString(c.obj) +
                                    " Count: " + Integer.toString(c.count));
                        }

                        for (Counter<IndiegogoPerk> c : perks.getAll()){
                            System.out.println("Perk label: " + c.obj.getLabel());
                            System.out.println("Perk description: " + c.obj.getDescription());
                            System.out.println("Perk id: " + c.obj.getId());
                            System.out.println("Count: " + Integer.toString(c.count));
                        }
                    }
            );

        } else {
            System.out.println("Not found");
        }
        id = in.nextInt();
        }


        /*
        //client.search("THe same title", indiegogoProjectSearchResponse.getPagination().getNext())




        client.searchAll("The Smallest 400x Microscope for Smartphone",0)
                .subscribe(
                        project -> {
                            System.out.println(project.toString());
                            projectsTable.addEntry(project);
                        },
                        throwable -> {throwable.printStackTrace();},
                        () -> {} // onComplete
                );

        id = in.nextInt();


        System.out.println("Choosed id: "+Integer.toString(id));

        final int finalId = id;
        IndiegogoProject p = projectsTable
                .request((Database.TableGetQuery<IndiegogoProject>) el -> el.getId() == finalId)
                .getFirst();

        if (p != null) {
            System.out.println(p.getTitle());
            client.getContributors(id).subscribe(
                    contrubutor -> {
                        contributorsTable.addEntry(contrubutor);
                    },
                    throwable -> {
                    },
                    () -> {
                        DatabaseTool.DatabaseToolBuilder<IndiegogoContributor> builder
                                = new DatabaseTool.DatabaseToolBuilder();
                        DatabaseTool<IndiegogoContributor> process = builder.withData(contributorsTable.getAll()).build();
                        ArrayList<Counter<Integer>> processed = process
                                .collect((var1, var2) -> var1.getAmount() == var2.getAmount())
                                .reduce(var1 -> new Counter<Integer>(var1.get(0).getAmount(), var1.size()))
                                .getData();

                        result.addAll(processed);
                        result.orderBy(Comparator.comparingInt(o -> o.obj));

                        DatabaseTool<IndiegogoContributor> processPerks =
                                builder.withData(contributorsTable.getAll()).build();

                        ArrayList<Counter<IndiegogoPerk>> perksCount = processPerks
                                .map(var -> var.getPerk())
                                .collect((var1, var2) -> var1.getId() == var2.getId())
                                .reduce(var1 -> new Counter<IndiegogoPerk>(var1.get(0), var1.size()))
                                .getData();

                        perks.addAll(perksCount);

                        for (Counter<Integer> c : result.getAll()) {
                            System.out.println("Amount: " + Integer.toString(c.obj) +
                                    " Count: " + Integer.toString(c.count));
                        }

                        for (Counter<IndiegogoPerk> c : perks.getAll()){
                            System.out.println("Perk label: " + c.obj.getLabel());
                            System.out.println("Perk description: " + c.obj.getDescription());
                            System.out.println("Perk id: " + c.obj.getId());
                            System.out.println("Count: " + Integer.toString(c.count));
                        }
                    }
            );

        } else {
            System.out.println("Not found");
        }
        id = in.nextInt();
*/
        return ViewUtil.render(request, model, Path.Template.SEARCH);
    };
}
