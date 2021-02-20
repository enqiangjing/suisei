package com.po.passwordonline.mapper;

import com.po.passwordonline.model.AccountInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountInfoMapper {

    List<AccountInfo> getAccountsList(AccountInfo accountInfo);

    List<AccountInfo> getAccountsListLike(String aLike);

    void insertData(AccountInfo accountInfo);

    void upDateInfo(AccountInfo accountInfo);
}
