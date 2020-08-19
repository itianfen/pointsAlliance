package com.utils;

/**
 * 角色枚举
 *
 * @author yangyantong
 */
public enum RoleLevel {
    /**
     * 角色名称对应等级
     */
    COMPANY_NORMAL("初级盟主", 31),
    COMPANY_GOLD("高级盟主", 32),
    COMPANY_DIAMOND("特级盟主", 33),
    MEMBER_NORMAL("普通会员", 21),
    MEMBER_GOLD("黄金会员", 22),
    MEMBER_DIAMOND("钻石会员", 23);

    /**
     * 会员名称
     */
    private String name;
    /**
     * 会员等级
     */
    private Integer level;

    RoleLevel(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public static String getRoleNameById(Integer state) {
        RoleLevel[] roleLevels = RoleLevel.values();
        for (RoleLevel roleLevel : roleLevels) {
            if (roleLevel.getLevel().compareTo(state) == 0) {
                return roleLevel.getName();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
