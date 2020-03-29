package com.portfolio.easyjob.service;

import com.portfolio.easyjob.domain.User;

public interface VerificationService {

    void verify(User admin, User userId, String statusUserPhoto, String statusPassport, String statusLegitimation);

    void verify(User admin, User userId, String statusUserPhoto, String statusPassport);
}
