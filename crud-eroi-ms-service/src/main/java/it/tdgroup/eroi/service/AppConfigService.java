package it.tdgroup.eroi.service;

import it.tdgroup.eroi.dto.AppConfigDTO;
import it.tdgroup.eroi.exception.ServiceException;

public interface AppConfigService {

    void setAppConfig(AppConfigDTO appConfig) throws ServiceException;

    AppConfigDTO getAppConfig(String nomeConfig) throws ServiceException;

    void removeAppConfig(String nomeConfig) throws ServiceException;

}
