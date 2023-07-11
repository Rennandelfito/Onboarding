package org.banking.entities.user;

import org.banking.entities.enums.ApproveEnum;

public class UserApproveRequest {
    ApproveEnum approveEnum;

    public ApproveEnum getApproveEnum() {
        return approveEnum;
    }

    public void setApproveEnum(ApproveEnum approveEnum) {
        this.approveEnum = approveEnum;
    }
}
