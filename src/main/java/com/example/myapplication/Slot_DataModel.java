package com.example.myapplication;

public class Slot_DataModel {

    String id,_Date,Arrival_time,Depart_time,username,vechle_no,status;

    public Slot_DataModel(String id, String _Date, String arrival_time, String depart_time, String username, String vechle_no, String status) {
        this.id = id;
        this._Date = _Date;
        this.Arrival_time = arrival_time;
        this.Depart_time = depart_time;
        this.username = username;
        this.vechle_no = vechle_no;
        this.status = status;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String get_Date() {
        return _Date;
    }

    public void set_Date(String _Date) {
        this._Date = _Date;
    }

    public String getArrival_time() {
        return Arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        Arrival_time = arrival_time;
    }

    public String getDepart_time() {
        return Depart_time;
    }

    public void setDepart_time(String depart_time) {
        Depart_time = depart_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVechle_no() {
        return vechle_no;
    }

    public void setVechle_no(String vechle_no) {
        this.vechle_no = vechle_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
