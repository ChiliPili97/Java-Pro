
select * from schedule.homework;

select * from schedule.lesson
inner join schedule.homework
on schedule.lesson.homework_id = schedule.homework.id;

select * from schedule.lesson
inner join schedule.homework
on schedule.lesson.homework_id = schedule.homework.id
order by schedule.lesson.updatedAt desc;

select schedule.schedule.*, schedule.lesson.name as lesson_name, schedule.lesson.updatedAt as lesson_updatedAt,
schedule.homework.name as homework_name, schedule.homework.description as homework_description
from schedule.schedule
inner join schedule.lessons_schedule on schedule.schedule.id = lessons_schedule.schedule_id
inner join schedule.lesson on schedule.lessons_schedule.lesson_id = lesson.id
inner join schedule.homework on schedule.lesson.homework_id = homework.id;

select schedule.schedule.id, schedule.schedule.name, count(*) as lesson_count
from schedule.schedule
inner join schedule.lessons_schedule on schedule.schedule.id = lessons_schedule.schedule;