package br.com.cominotti.olympics_api.server.application.use_cases;

import javax.ws.rs.QueryParam;

public class ListCompetitionsUseCaseInput {

    @QueryParam("modalityId")
    private Integer modalityId;


    public Integer getModalityId() {
        return modalityId;
    }

    public void setModalityId(Integer modalityId) {
        this.modalityId = modalityId;
    }
}
