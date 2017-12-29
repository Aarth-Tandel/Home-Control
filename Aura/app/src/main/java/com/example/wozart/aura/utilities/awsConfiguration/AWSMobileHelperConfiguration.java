package com.example.wozart.aura.utilities.awsConfiguration;

import com.amazonaws.regions.Regions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wozart on 29/12/17.
 */

public class AWSMobileHelperConfiguration {
    private static final String CONFIG_KEY_COGNITO_REGION = "cognitoRegion";
    private static final String CONFIG_KEY_COGNITO_IDENTITY_POOL_ID = "cognitoPoolId";
    private static final String CONFIG_KEY_COGNITO_USER_POOL_ID = "cognitoUserPoolId";
    private static final String CONFIG_KEY_COGNITO_USER_POOL_CLIENT_ID = "cognitoUserPoolClientId";
    private static final String CONFIG_KEY_COGNITO_USER_POOL_CLIENT_SECRET = "cognitoUserPoolClientSecret";
    private static final String CONFIG_KEY_SIGN_IN_BACKGROUND_COLOR = "signInBackgroundColor";
    private static final String CONFIG_KEY_SIGN_IN_IMAGE_RESOURCE_ID = "signInImageResId";

    /**
     * Mapping for configuration values.
     */
    private final Map<String, Object> config;

    private AWSMobileHelperConfiguration(final Map<String, Object> config) {
        this.config = config;
    }

    public Regions getCognitoRegion() {
        return (Regions) config.get(CONFIG_KEY_COGNITO_REGION);
    }

    /**
     * @return the Cognito Identity Pool ID.
     */
    public String getCognitoIdentityPoolId() {
        return (String) config.get(CONFIG_KEY_COGNITO_IDENTITY_POOL_ID);
    }

    /**
     * @return the Cognito Identity Pool ID.
     */
    public String getCognitoUserPoolId() {
        return (String) config.get(CONFIG_KEY_COGNITO_USER_POOL_ID);
    }

    /**
     * @return the Cognito User Pool Client ID.
     */
    public String getCognitoUserPoolClientId() {
        return (String) config.get(CONFIG_KEY_COGNITO_USER_POOL_CLIENT_ID);
    }

    /**
     * @return the Cognito User Pool Client Secret.
     */
    public String getCognitoUserPoolClientSecret() {
        return (String) config.get(CONFIG_KEY_COGNITO_USER_POOL_CLIENT_SECRET);
    }

    public int getSignInBackgroundColor(final int defaultBackgroundColor) {
        final Integer backgroundColor = (Integer) config.get(CONFIG_KEY_SIGN_IN_BACKGROUND_COLOR);
        if (backgroundColor == null) {
            return defaultBackgroundColor;
        }
        return backgroundColor;
    }

    public int getSignImageResourceId(final int defaultResourceId) {
        final Integer resId = (Integer) config.get(CONFIG_KEY_SIGN_IN_IMAGE_RESOURCE_ID);
        if (resId == null) {
            return defaultResourceId;
        }
        return resId;
    }

    /**
     * Builder to aid in creating an AWSMobileHelperConfiguration.
     */
    public static class Builder {
        final Map<String, Object> config = new HashMap<>();

        /**
         * Sets the Cognito Region for the configuration to be built.
         *
         * @param region the region.
         * @return the builder for chaining.
         */
        public Builder withCognitoRegion(final Regions region) {
            config.put(CONFIG_KEY_COGNITO_REGION, region);
            return this;
        }

        /**
         * Sets the Cognito Identity Pool ID for the configuration to be built.
         * @param identityPoolId the identity pool id.
         * @return the builder for chaining.
         */
        public Builder withCognitoIdentityPoolId(final String identityPoolId) {
            config.put(CONFIG_KEY_COGNITO_IDENTITY_POOL_ID, identityPoolId);
            return this;
        }

        public Builder withCognitoUserPool(final String userPoolId,
                                           final String userPoolClientId,
                                           final String userPoolClientSecret) {
            config.put(CONFIG_KEY_COGNITO_USER_POOL_ID, userPoolId);
            config.put(CONFIG_KEY_COGNITO_USER_POOL_CLIENT_ID, userPoolClientId);
            config.put(CONFIG_KEY_COGNITO_USER_POOL_CLIENT_SECRET, userPoolClientSecret);
            return this;
        }

        public Builder withSignInBackgroundColor(final int backgroundColor) {
            config.put(CONFIG_KEY_SIGN_IN_BACKGROUND_COLOR, backgroundColor);
            return this;
        }

        public Builder withSignInImage(final int imageResId) {
            config.put(CONFIG_KEY_SIGN_IN_IMAGE_RESOURCE_ID, imageResId);
            return this;
        }

        /**
         * Builds the Configuration.
         *
         * @return the configuration.
         */
        public AWSMobileHelperConfiguration build() {
            return new AWSMobileHelperConfiguration(config);
        }
    }

}
