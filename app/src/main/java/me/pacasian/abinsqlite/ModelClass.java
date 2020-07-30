package me.pacasian.abinsqlite;


public class ModelClass
{

    public String id; //matter
    public String matter; //timedate
    public String date;
    public ModelClass(String id, String matter,String date)
    {
        this.id = id;
        this.matter = matter;
        this.date=date;

    }

    public String getId() {
        return id;
    }

    public String getMatter() {
        return matter;
    }
    public String getDate() {
        return date;
    }

}