create table comment
(
    id           bigint auto_increment,
    parent_id    bigint           not null comment '父类id
',
    type         int              null comment '父类类型',
    commentator  int              null comment '评论id',
    gmt_create   bigint           not null comment '创建时间',
    gmt_modified bigint           not null comment '更新时间',
    like_count   bigint default 0 null comment '点赞数',
    constraint comment_pk
        primary key (id)
);