package com.prylipko.oleg.domain;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractComplaint extends AbstractEntity {

    @ManyToOne
    private User author;

    @Column(name = "complaint_type")
    @Enumerated(EnumType.STRING)
    private ComplaintType complaintType;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
