package com.botree.hackathon.model;

public class UserModel {

    /** email. */
    private String email;
    /** password. */
    private String password;
    /** id. */
    private String id;
    /** first_name. */
    private String first_name;
    /** last_name. */
    private String last_name;
    /** company_id. */
    private String company_id;
    /** token. */
    private String token;

    /**
     * @return the email
     */
    public final String getEmail() {
        return email;
    }

    /**
     * @param emailIn the email to set
     */
    public final void setEmail(final String emailIn) {
        email = emailIn;
    }

    /**
     * @return the password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * @param passwordIn the password to set
     */
    public final void setPassword(final String passwordIn) {
        password = passwordIn;
    }

    /**
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * @param idIn the id to set
     */
    public final void setId(final String idIn) {
        id = idIn;
    }

    /**
     * @return the first_name
     */
    public final String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_nameIn the first_name to set
     */
    public final void setFirst_name(final String first_nameIn) {
        first_name = first_nameIn;
    }

    /**
     * @return the last_name
     */
    public final String getLast_name() {
        return last_name;
    }

    /**
     * @param last_nameIn the last_name to set
     */
    public final void setLast_name(final String last_nameIn) {
        last_name = last_nameIn;
    }

    /**
     * @return the company_id
     */
    public final String getCompany_id() {
        return company_id;
    }

    /**
     * @param company_idIn the company_id to set
     */
    public final void setCompany_id(final String company_idIn) {
        company_id = company_idIn;
    }

    /**
     * @return the token
     */
    public final String getToken() {
        return token;
    }

    /**
     * @param tokenIn the token to set
     */
    public final void setToken(final String tokenIn) {
        token = tokenIn;
    }
}
