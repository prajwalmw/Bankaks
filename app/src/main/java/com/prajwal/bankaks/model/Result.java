package com.prajwal.bankaks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Prajwal Waingankar
 * on 03-Dec-20.
 * Github: prajwalmw
 */


public class Result {
    @SerializedName("number_of_fields")
    @Expose
    private Long numberOfFields;
    @SerializedName("screen_title")
    @Expose
    private String screenTitle;
    @SerializedName("operator_name")
    @Expose
    private String operatorName;
    @SerializedName("service_id")
    @Expose
    private String serviceId;
    @SerializedName("fields")
    @Expose
    private List<Field> fields = null;

    public Long getNumberOfFields() {
        return numberOfFields;
    }

    public void setNumberOfFields(Long numberOfFields) {
        this.numberOfFields = numberOfFields;
    }

    public String getScreenTitle() {
        return screenTitle;
    }

    public void setScreenTitle(String screenTitle) {
        this.screenTitle = screenTitle;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
