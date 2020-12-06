package com.prajwal.bankaks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Prajwal Waingankar
 * on 03-Dec-20.
 * Github: prajwalmw
 */


public class Type {
    @SerializedName("data_type")
    @Expose
    private String dataType;
    @SerializedName("is_array")
    @Expose
    private String isArray;
    @SerializedName("array_name")
    @Expose
    private String arrayName;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getIsArray() {
        return isArray;
    }

    public void setIsArray(String isArray) {
        this.isArray = isArray;
    }

    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }
}
