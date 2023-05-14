create table schedule.homework (
    id bigserial primary key,
    name varchar(255),
    description text
);

create table schedule.lesson (
    id bigserial primary key,
    name varchar(255),
    updatedAt timestamp default now(),
    homework_id bigint,
    constraint lesson_id_fk foreign key (homework_id) references schedule.homework(id)
);

create table schedule.schedule (
    id bigserial primary key,
    name varchar(255),
    updateAt timestamp default now()
);

create table schedule.lessons_schedule (
    lesson_id bigint,
    schedule_id bigint,
    primary key (lesson_id, schedule_id),
    constraint lesson_fk foreign key (lesson_id) references schedule.lesson(id),
    constraint schedule_fk foreign key (schedule_id) references schedule.schedule(id)
);
