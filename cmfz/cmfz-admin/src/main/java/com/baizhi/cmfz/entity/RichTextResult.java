package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-07-08.
 */
public class RichTextResult implements Serializable {
    private  Integer errno;

    private List<String> data;

    public RichTextResult() {
    }

    public RichTextResult(Integer errno, List<String> data) {
        this.errno = errno;
        this.data = data;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RichTextResult{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }
}
