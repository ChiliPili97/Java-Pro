create table homework.homework (
    id bigserial primary key,
    name varchar(255),
    description text
);

create table homework.lesson (
    id bigserial primary key,
    name varchar(255),
    updateAt timestamp,
    homework_id bigint,
    constraint lesson_id_fk foreign key (homework_id) references homework.homework(id)
);

create table homework.schedule (
    id bigserial primary key,
    name varchar(255),
    updateAt timestamp
);

create table homework.lessons_schedule (
    lesson_id bigint,
    schedule_id bigint,
    primary key (lesson_id, schedule_id),
    constraint lesson_fk foreign key (lesson_id) references homework.lesson(id),
    constraint schedule_fk foreign key (schedule_id) references homework.schedule(id)
);