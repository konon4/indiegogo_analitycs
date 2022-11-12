package database;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Created by volk on 01.03.2017.
 */
public class Database {

    private HashMap<String, Table> db = new HashMap<>();
    private Object lock = new Object();

    public Database() {

    }

    private void addTable(Table table){
        synchronized (lock) {
            db.put(table.name,table);
        }
    }

    public Table getTable(String name){
        synchronized (lock){
            return db.get(name);
        }
    }

    public static class Table<T>{
        final ArrayList<T> table;
        final String name;

        Table(ArrayList<T> table, String name){
            this.table = table;
            this.name = name;
        }

        public void addEntry(T entry){
            synchronized (table) {
                table.add(entry);
            }
        }

        public void addAll(List<T> entry){
            synchronized (table) {
                for (T e : entry)
                    table.add(e);
            }
        }

        public ArrayList<T> getAll(){
            return (ArrayList<T>) table.clone();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Table)
                if (((Table) obj).name.equals(this.name))
                    return true;
            else if (obj instanceof String)
                if (this.name.equals(obj))
                    return true;
            return false;
        }

        public Table<T> request(TableQuery<T> query) {
            if (query instanceof TableGetQuery){
                ArrayList<T> result = new ArrayList<T>();
                for (T row : table){
                    if (((TableGetQuery) query).isTarget(row)){
                        result.add(row);
                    }
                }
                return new Table<T>(result, "Temporary table");
            }
            return null;
        }

        public Table<T>  orderBy(Comparator<T> order){
            table.sort(order);
            return this;
        }

        public T getFirst() {
            return this.table.get(0);
        }
    }

    public interface TableQuery<TQ>{}

    public interface TableGetQuery<TGQ> extends TableQuery<TGQ> {
        boolean isTarget(TGQ el);
    }

    public class TableGetAllQuery<TGA> implements TableGetQuery<TGA>{
        @Override
        public boolean isTarget(TGA el) {
            return true;
        }
    }

    public static class TableBuilder<TB>{
        final String name;
        Database database = null;
        public TableBuilder(String name){
            this.name = name;
        }
        public TableBuilder<TB> setDatabase(Database database){
            this.database = database;
            return this;
        }
        public Table build(){
            Table result = new Table<TB>(new ArrayList<TB>(),name);
            if (database != null){
                database.addTable(new Table<TB>(new ArrayList<TB>(),name));
            }
            return result;
        }
    }
}
