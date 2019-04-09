package it.tdgroup.eroi.serviceimpl;

import it.tdgroup.eroi.dto.AppConfigDTO;
import it.tdgroup.eroi.exception.ServiceException;
import it.tdgroup.eroi.mapperimpl.AppConfigMapperImpl;
import it.tdgroup.eroi.repository.AppConfigRepository;
import it.tdgroup.eroi.service.AppConfigService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppConfigServiceImpl implements AppConfigService {

    private static final Log LOG = LogFactory.getLog(AppConfigServiceImpl.class);

    @Autowired
    private AppConfigMapperImpl appConfigMapper;

    @Autowired
    private AppConfigRepository appConfigRepository;

    @Override
    public void setAppConfig(AppConfigDTO appConfig) throws ServiceException {
        try {
            appConfigRepository.save(appConfigMapper.convertDtoToEntity(appConfig));
        } catch (Exception ex) {
            LOG.error("Errore durante setAppConfig: " + ex.getMessage(), ex);
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public AppConfigDTO getAppConfig(String nomeConfig) throws ServiceException {
        try {
            return appConfigMapper.convertEntityToDto(appConfigRepository.findAppConfig(nomeConfig));
        } catch (Exception ex) {
            LOG.error("Errore durante getAppConfig: " + ex.getMessage(), ex);
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public void removeAppConfig(String nomeConfig) throws ServiceException {
        try {
            appConfigRepository.deleteConfig(nomeConfig);
        } catch (Exception ex) {
            LOG.error("Errore durante removeAppConfig: " + ex.getMessage(), ex);
            throw new ServiceException(ex.getMessage());
        }
    }
}
