package br.com.cominotti.olympics_api.server.infrastructure.localization;

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
