# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table author (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_author primary key (id))
;

create table book (
  id                        bigint not null,
  title                     varchar(255),
  isbn                      varchar(255),
  publisher_id              bigint,
  publisher_text            varchar(255),
  authors_text              varchar(255),
  catalogue_count           integer,
  publish_year              bigint,
  constraint pk_book primary key (id))
;

create table borrowing (
  id                        bigint not null,
  user_username             varchar(255),
  student_id                bigint,
  catalogue_id              bigint,
  borrow_date               timestamp,
  must_return_date          timestamp,
  renewal_date              timestamp,
  return_date               timestamp,
  renewal_count             integer,
  fine                      bigint,
  constraint pk_borrowing primary key (id))
;

create table catalogue (
  id                        bigint not null,
  book_id                   bigint,
  barcode                   varchar(255),
  status_id                 bigint,
  constraint uq_catalogue_barcode unique (barcode),
  constraint pk_catalogue primary key (id))
;

create table catalogue_status (
  id                        bigint not null,
  status                    varchar(255),
  constraint pk_catalogue_status primary key (id))
;

create table faculty (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_faculty primary key (id))
;

create table library_config (
  id                        bigint not null,
  name                      varchar(255),
  value                     varchar(255),
  constraint pk_library_config primary key (id))
;

create table publisher (
  id                        bigint not null,
  name                      varchar(255),
  constraint uq_publisher_name unique (name),
  constraint pk_publisher primary key (id))
;

create table student (
  id                        bigint not null,
  name                      varchar(255),
  nim                       varchar(255),
  faculty_id                bigint,
  constraint pk_student primary key (id))
;

create table userx (
  username                  varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_userx primary key (username))
;


create table author_book (
  author_id                      bigint not null,
  book_id                        bigint not null,
  constraint pk_author_book primary key (author_id, book_id))
;
create sequence author_seq;

create sequence book_seq;

create sequence borrowing_seq;

create sequence catalogue_seq;

create sequence catalogue_status_seq;

create sequence faculty_seq;

create sequence library_config_seq;

create sequence publisher_seq;

create sequence student_seq;

create sequence userx_seq;

alter table book add constraint fk_book_publisher_1 foreign key (publisher_id) references publisher (id);
create index ix_book_publisher_1 on book (publisher_id);
alter table borrowing add constraint fk_borrowing_user_2 foreign key (user_username) references userx (username);
create index ix_borrowing_user_2 on borrowing (user_username);
alter table borrowing add constraint fk_borrowing_student_3 foreign key (student_id) references student (id);
create index ix_borrowing_student_3 on borrowing (student_id);
alter table borrowing add constraint fk_borrowing_catalogue_4 foreign key (catalogue_id) references catalogue (id);
create index ix_borrowing_catalogue_4 on borrowing (catalogue_id);
alter table catalogue add constraint fk_catalogue_book_5 foreign key (book_id) references book (id);
create index ix_catalogue_book_5 on catalogue (book_id);
alter table catalogue add constraint fk_catalogue_status_6 foreign key (status_id) references catalogue_status (id);
create index ix_catalogue_status_6 on catalogue (status_id);
alter table student add constraint fk_student_faculty_7 foreign key (faculty_id) references faculty (id);
create index ix_student_faculty_7 on student (faculty_id);



alter table author_book add constraint fk_author_book_author_01 foreign key (author_id) references author (id);

alter table author_book add constraint fk_author_book_book_02 foreign key (book_id) references book (id);

# --- !Downs

drop table if exists author cascade;

drop table if exists author_book cascade;

drop table if exists book cascade;

drop table if exists borrowing cascade;

drop table if exists catalogue cascade;

drop table if exists catalogue_status cascade;

drop table if exists faculty cascade;

drop table if exists library_config cascade;

drop table if exists publisher cascade;

drop table if exists student cascade;

drop table if exists userx cascade;

drop sequence if exists author_seq;

drop sequence if exists book_seq;

drop sequence if exists borrowing_seq;

drop sequence if exists catalogue_seq;

drop sequence if exists catalogue_status_seq;

drop sequence if exists faculty_seq;

drop sequence if exists library_config_seq;

drop sequence if exists publisher_seq;

drop sequence if exists student_seq;

drop sequence if exists userx_seq;

