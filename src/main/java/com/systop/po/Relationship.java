package com.systop.po;

public class Relationship {
    private Integer relationship_id;
    private Integer relationship_user_id;
    private Integer relationship_author_id;

    public Integer getRelationship_id() {
        return relationship_id;
    }

    public void setRelationship_id(Integer relationship_id) {
        this.relationship_id = relationship_id;
    }

    public Integer getRelationship_user_id() {
        return relationship_user_id;
    }

    public void setRelationship_user_id(Integer relationship_user_id) {
        this.relationship_user_id = relationship_user_id;
    }

    public Integer getRelationship_author_id() {
        return relationship_author_id;
    }

    public void setRelationship_author_id(Integer relationship_author_id) {
        this.relationship_author_id = relationship_author_id;
    }
}
