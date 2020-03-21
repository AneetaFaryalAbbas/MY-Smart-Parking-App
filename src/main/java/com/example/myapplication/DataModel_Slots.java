package com.example.myapplication;

public class DataModel_Slots {

    String id,slotNo,status;

    public DataModel_Slots(String id, String slotNo, String status) {
        this.id = id;
        this.slotNo = slotNo;
        this.status = status;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(String slotNo) {
        this.slotNo = slotNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
