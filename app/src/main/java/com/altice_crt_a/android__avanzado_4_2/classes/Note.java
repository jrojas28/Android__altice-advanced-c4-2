package com.altice_crt_a.android__avanzado_4_2.classes;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;

/**
 * Created by jaime on 6/2/2018.
 */

@Entity
public class Note {
    @Id(autoincrement = true)
    private Long id;
    private String content;

    public Note() {};

    @Keep
    public Note(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(long id) {
        this.id = id;
    }
}
