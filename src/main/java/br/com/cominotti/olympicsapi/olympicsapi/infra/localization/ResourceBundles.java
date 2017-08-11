package br.com.cominotti.olympicsapi.olympicsapi.infra.localization;

public enum ResourceBundles {

    ERRORS("errors");

    private final String bundleName;


    ResourceBundles(final String bundleName) {
        this.bundleName = bundleName;
    }


    public String getBundleName() {
        return bundleName;
    }

    @Override
    public String toString() {
        return bundleName;
    }
}
