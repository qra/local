package com.example.qrazy.qrazyapplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

    public SearchRecord(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public SearchRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcontent() {
        return content;
    }

    public void setcontent(String content) {
        this.content = content;
    }
}
