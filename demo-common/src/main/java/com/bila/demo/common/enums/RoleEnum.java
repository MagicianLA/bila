package com.bila.demo.common.enums;

import lombok.Getter;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2019/12/18
 * @Modify By:
 */
@Getter
public enum RoleEnum implements RoleOperation {

    /**
     * 管理员
     */
    ROLE_ADMIN("管理员") {
        @Override
        public void operate() {
            System.out.println("I am ROLE_ADMIN");
        }
    },
    ROLE_NORMAL("普通角色") {
        @Override
        public void operate() {
            System.out.println("I am ROLE_NORMAL");
        }
    };

    private String roleName;
    RoleEnum(String roleName) {
        this.roleName = roleName;
    }

}
