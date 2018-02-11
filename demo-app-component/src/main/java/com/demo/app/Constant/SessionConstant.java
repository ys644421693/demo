package com.demo.app.Constant;

public enum SessionConstant {

    USER_SESSION("USER_SESSION", 1,"用户Session");
    // 成员变量
    private String name;
    private int index;
    private String description;
    // 构造方法
    private SessionConstant(String name, int index,String description) {
        this.name = name;
        this.index = index;
        this.description = description;
    }

    // 普通方法
    public static String getName(int index) {
        for (SessionConstant c : SessionConstant.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
