package database;

import rest.models.IndiegogoContributor;
import rest.models.IndiegogoPerk;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by volk on 03.03.2017.
 */
public class DatabaseTool<TT> {

    private ArrayList<TT> data;

    private DatabaseTool(ArrayList<TT> data){
        this.data = data;
    }

    public static class DatabaseToolBuilder<BT>{
        ArrayList<BT> data;

        public DatabaseToolBuilder(){
            data = new ArrayList<>();
        }

        public DatabaseToolBuilder<BT> withData(ArrayList<BT> data){
            this.data = (ArrayList<BT>) data.clone();
            return this;
        }

        public DatabaseTool<BT> build(){
            return new DatabaseTool<BT>(data);
        }
    }

    public class CollectedDatabaseTool<CT> {
        ArrayList<ArrayList<CT>> collection;

        CollectedDatabaseTool(ArrayList<ArrayList<CT>> collection){
            this.collection = collection;
        }

        public <NN> DatabaseTool<NN> reduce(Reduce<NN,CT> reducer){
            ArrayList<NN> result = new ArrayList<NN>();
            for (ArrayList<CT> c : collection){
                result.add(reducer.reduce(c));
            }
            return new DatabaseTool<NN>(result);
        }

        public <U> CollectedDatabaseTool<U> map(Mapper<U,CT> mapper){
            ArrayList<ArrayList<U>> result = new ArrayList<>();
            for (ArrayList<CT> c : collection) {
                ArrayList<U> tmp = new ArrayList<>();
                for (CT el : c) {
                    tmp.add(mapper.map(el));
                }
                result.add(tmp);
            }
            return new CollectedDatabaseTool<U>(result);
        }
    }

    public CollectedDatabaseTool<TT> collect(Collector<TT> collector){
        ArrayList<ArrayList<TT>> result = new ArrayList<>();
        boolean added = false;
        for (TT el : data){
            if (el != null) {
                added = false;
                if (!result.isEmpty()) {
                    for (ArrayList<TT> r : result) {
                        if ((!r.isEmpty()) && collector.collect(r.get(0), el)) {
                            r.add(el);
                            added = true;
                        }
                    }
                }

                if (!added) {
                    ArrayList<TT> tmp = new ArrayList<TT>();
                    tmp.add(el);
                    result.add(tmp);
                }
            }
        }
        return new CollectedDatabaseTool<TT>(result);
    }

    public <NN> DatabaseTool<NN> reduce(Reduce<NN,TT> reducer) {
        NN d = reducer.reduce(data);
        ArrayList<NN> result = new ArrayList<>();
        result.add(d);
        return new DatabaseTool<NN>(result);
    }

    public <U> DatabaseTool<U> map(Mapper<U, TT> mapper){
        ArrayList<U> result = new ArrayList<>();
        for (TT el : data){
            result.add(mapper.map(el));
        }
        return new DatabaseTool<U>(result);
    }

    public ArrayList<TT> getData(){
        return (ArrayList<TT>) data.clone();
    }

    public interface Collector<T>{
        boolean collect(T var1, T var2);
    }

    public interface Reduce<N,T>{
        N reduce(ArrayList<T> var1);
    }

    public interface Mapper<NewType,Type>{
        NewType map(Type var);
    }
}
