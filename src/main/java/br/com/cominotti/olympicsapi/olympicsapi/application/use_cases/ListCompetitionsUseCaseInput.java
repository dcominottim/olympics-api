package br.com.cominotti.olympicsapi.olympicsapi.application.use_cases;

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
