package com.tutorial.model;

/**
 * Created by jianle on 18-8-14.
 */
public class Mini {

    private Long id;
    private String message;

    public Mini() {}
    public Mini(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Mini)) {
            return false;
        }
        Mini m = (Mini) obj;
        return id.equals(m.id);
    }
}
