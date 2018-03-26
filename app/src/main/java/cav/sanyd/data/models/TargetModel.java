package cav.sanyd.data.models;

import java.util.Date;

public class TargetModel {
    private int mid;
    private String mTargetTitle;
    private String mComment;
    private Date mStartDate;
    private Date mEndDate;
    private int mQuantity; // количество ?
    private int mCountTick; // частота отчета
    private int mMes ;// еденицы ?
    private int mTypeMes; // тип еденниы / цели ?

    public TargetModel(int mid, String targetTitle, String comment, Date startDate, Date endDate, int quantity, int countTick, int mes, int typeMes) {
        this.mid = mid;
        mTargetTitle = targetTitle;
        mComment = comment;
        mStartDate = startDate;
        mEndDate = endDate;
        mQuantity = quantity;
        mCountTick = countTick;
        mMes = mes;
        mTypeMes = typeMes;
    }

    public int getMid() {
        return mid;
    }

    public String getTargetTitle() {
        return mTargetTitle;
    }

    public String getComment() {
        return mComment;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public int getCountTick() {
        return mCountTick;
    }

    public int getMes() {
        return mMes;
    }

    public int getTypeMes() {
        return mTypeMes;
    }
}