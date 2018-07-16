package com.example.qrazy.qrazyapplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Wu on 2017/4/26 0026 下午 5:06.
 * 描述：GreenDao库
 */

@Entity
class SearchRecord {
    //主键自增
    @Id(autoincrement = true)
    private Long id;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }



    public SearchRecord() {
    }

    @Generated(hash = 815440565)
    public SearchRecord(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
