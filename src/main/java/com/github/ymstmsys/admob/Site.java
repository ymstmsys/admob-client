package com.github.ymstmsys.admob;

import java.io.Serializable;

/**
 * @author ymstmsys
 */
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String url;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Site [id=" + id + ", name=" + name + ", url=" + url + ", description=" + description + "]";
    }

}
