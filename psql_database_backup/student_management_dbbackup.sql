--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-03-26 22:54:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 16430)
-- Name: address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.address (
    id_address bigint NOT NULL,
    street text,
    street_no text,
    country text
);


ALTER TABLE public.address OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16472)
-- Name: assignment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.assignment (
    id_assignment bigint NOT NULL,
    shift text,
    id_student bigint,
    id_course bigint
);


ALTER TABLE public.assignment OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16471)
-- Name: asignation_id_asignation_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.assignment ALTER COLUMN id_assignment ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.asignation_id_asignation_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 218 (class 1259 OID 16438)
-- Name: contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contact (
    id_contact bigint NOT NULL,
    phone_number text,
    email text
);


ALTER TABLE public.contact OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16437)
-- Name: contacto_id_contacto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.contact ALTER COLUMN id_contact ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.contacto_id_contacto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 220 (class 1259 OID 16446)
-- Name: course; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course (
    id_course bigint NOT NULL,
    name text,
    price double precision
);


ALTER TABLE public.course OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16445)
-- Name: course_id_course_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.course ALTER COLUMN id_course ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.course_id_course_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 215 (class 1259 OID 16429)
-- Name: domicilio_id_domicilio_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.address ALTER COLUMN id_address ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.domicilio_id_domicilio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 228 (class 1259 OID 16498)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id_role bigint NOT NULL,
    name text,
    id_user bigint
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16497)
-- Name: role_id_role_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.role ALTER COLUMN id_role ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.role_id_role_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 222 (class 1259 OID 16454)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    id_student bigint NOT NULL,
    name text,
    surname text,
    id_address bigint,
    id_contact bigint
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16453)
-- Name: student_id_student_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.student ALTER COLUMN id_student ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.student_id_student_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 226 (class 1259 OID 16490)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id_user bigint NOT NULL,
    username text,
    password text
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16489)
-- Name: user_id_user_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."user" ALTER COLUMN id_user ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_id_user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 4827 (class 0 OID 16430)
-- Dependencies: 216
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.address OVERRIDING SYSTEM VALUE VALUES (2, 'Venus', '555', 'Argentina');
INSERT INTO public.address OVERRIDING SYSTEM VALUE VALUES (3, 'Uranus', '456', 'Argentina');
INSERT INTO public.address OVERRIDING SYSTEM VALUE VALUES (4, 'Mars', '148', 'United States');
INSERT INTO public.address OVERRIDING SYSTEM VALUE VALUES (5, '', '', '');
INSERT INTO public.address OVERRIDING SYSTEM VALUE VALUES (6, 'Sun', '888', 'England');
INSERT INTO public.address OVERRIDING SYSTEM VALUE VALUES (7, 'Neptunus', '149', 'Mexico');
INSERT INTO public.address OVERRIDING SYSTEM VALUE VALUES (1, 'Jupiter', '120', 'Argentina');
INSERT INTO public.address OVERRIDING SYSTEM VALUE VALUES (8, 'Sun', '881', 'Colombia');
INSERT INTO public.address OVERRIDING SYSTEM VALUE VALUES (9, 'Jupiter', '991', 'United States');
INSERT INTO public.address OVERRIDING SYSTEM VALUE VALUES (10, 'Neptunus', '123', 'Argentina');


--
-- TOC entry 4835 (class 0 OID 16472)
-- Dependencies: 224
-- Data for Name: assignment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.assignment OVERRIDING SYSTEM VALUE VALUES (13, 'Afternoon', 10, 1);


--
-- TOC entry 4829 (class 0 OID 16438)
-- Dependencies: 218
-- Data for Name: contact; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.contact OVERRIDING SYSTEM VALUE VALUES (1, '11223344', 'jperez@mail.com');
INSERT INTO public.contact OVERRIDING SYSTEM VALUE VALUES (2, '55667788', 'clara@mail.com');
INSERT INTO public.contact OVERRIDING SYSTEM VALUE VALUES (3, '11435566', 'rjuarez@mail.com');
INSERT INTO public.contact OVERRIDING SYSTEM VALUE VALUES (4, '99881122', 'jsmith@mail.com');
INSERT INTO public.contact OVERRIDING SYSTEM VALUE VALUES (5, '', '');
INSERT INTO public.contact OVERRIDING SYSTEM VALUE VALUES (6, '22882299', 'jdoe@mail.com');
INSERT INTO public.contact OVERRIDING SYSTEM VALUE VALUES (7, '33009922', 'malvarado@mail.com');
INSERT INTO public.contact OVERRIDING SYSTEM VALUE VALUES (8, '12121212', 'jandrade@mail.com');
INSERT INTO public.contact OVERRIDING SYSTEM VALUE VALUES (9, '11223344', 'jsmith@mail.com');
INSERT INTO public.contact OVERRIDING SYSTEM VALUE VALUES (10, '11223344', 'jperez@mail.com');


--
-- TOC entry 4831 (class 0 OID 16446)
-- Dependencies: 220
-- Data for Name: course; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.course OVERRIDING SYSTEM VALUE VALUES (1, 'Introduction to Programming', 5000);
INSERT INTO public.course OVERRIDING SYSTEM VALUE VALUES (3, 'Computer Science Degree', 55000);
INSERT INTO public.course OVERRIDING SYSTEM VALUE VALUES (7, 'Digital Marketing', 8000);


--
-- TOC entry 4839 (class 0 OID 16498)
-- Dependencies: 228
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role OVERRIDING SYSTEM VALUE VALUES (1, 'ROLE_USER', 1);
INSERT INTO public.role OVERRIDING SYSTEM VALUE VALUES (2, 'ROLE_USER', 2);
INSERT INTO public.role OVERRIDING SYSTEM VALUE VALUES (3, 'ROLE_ADMIN', 2);


--
-- TOC entry 4833 (class 0 OID 16454)
-- Dependencies: 222
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.student OVERRIDING SYSTEM VALUE VALUES (10, 'Juan', 'Perez', 10, 10);


--
-- TOC entry 4837 (class 0 OID 16490)
-- Dependencies: 226
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."user" OVERRIDING SYSTEM VALUE VALUES (1, 'user1', '$2a$10$egFdS0kFOjDwFb4I3mfA7uXL7kZHp8NzxhxZiEW6EBUx6wr/vCgt.');
INSERT INTO public."user" OVERRIDING SYSTEM VALUE VALUES (2, 'admin1', '$2a$10$lx6lBOe2jtWelaX9TXl7K.iK6I4k0dOYtDuyHRHXZ4RkJJlPDKUsS');


--
-- TOC entry 4845 (class 0 OID 0)
-- Dependencies: 223
-- Name: asignation_id_asignation_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.asignation_id_asignation_seq', 13, true);


--
-- TOC entry 4846 (class 0 OID 0)
-- Dependencies: 217
-- Name: contacto_id_contacto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contacto_id_contacto_seq', 10, true);


--
-- TOC entry 4847 (class 0 OID 0)
-- Dependencies: 219
-- Name: course_id_course_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.course_id_course_seq', 7, true);


--
-- TOC entry 4848 (class 0 OID 0)
-- Dependencies: 215
-- Name: domicilio_id_domicilio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.domicilio_id_domicilio_seq', 10, true);


--
-- TOC entry 4849 (class 0 OID 0)
-- Dependencies: 227
-- Name: role_id_role_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_role_seq', 3, true);


--
-- TOC entry 4850 (class 0 OID 0)
-- Dependencies: 221
-- Name: student_id_student_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_id_student_seq', 10, true);


--
-- TOC entry 4851 (class 0 OID 0)
-- Dependencies: 225
-- Name: user_id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_user_seq', 2, true);


--
-- TOC entry 4673 (class 2606 OID 16478)
-- Name: assignment assignment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignment
    ADD CONSTRAINT assignment_pkey PRIMARY KEY (id_assignment);


--
-- TOC entry 4667 (class 2606 OID 16444)
-- Name: contact contacto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contacto_pkey PRIMARY KEY (id_contact);


--
-- TOC entry 4669 (class 2606 OID 16452)
-- Name: course course_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id_course);


--
-- TOC entry 4665 (class 2606 OID 16436)
-- Name: address domicilio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT domicilio_pkey PRIMARY KEY (id_address);


--
-- TOC entry 4677 (class 2606 OID 16504)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id_role);


--
-- TOC entry 4671 (class 2606 OID 16460)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id_student);


--
-- TOC entry 4675 (class 2606 OID 16496)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id_user);


--
-- TOC entry 4678 (class 2606 OID 16461)
-- Name: student id_address_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT id_address_fkey FOREIGN KEY (id_address) REFERENCES public.address(id_address) NOT VALID;


--
-- TOC entry 4679 (class 2606 OID 16466)
-- Name: student id_contact_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT id_contact_fkey FOREIGN KEY (id_contact) REFERENCES public.contact(id_contact) NOT VALID;


--
-- TOC entry 4680 (class 2606 OID 16484)
-- Name: assignment id_course_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignment
    ADD CONSTRAINT id_course_fkey FOREIGN KEY (id_course) REFERENCES public.course(id_course) NOT VALID;


--
-- TOC entry 4681 (class 2606 OID 16479)
-- Name: assignment id_student_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.assignment
    ADD CONSTRAINT id_student_fkey FOREIGN KEY (id_student) REFERENCES public.student(id_student) NOT VALID;


--
-- TOC entry 4682 (class 2606 OID 16505)
-- Name: role id_user_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT id_user_fkey FOREIGN KEY (id_user) REFERENCES public."user"(id_user) NOT VALID;


-- Completed on 2024-03-26 22:54:03

--
-- PostgreSQL database dump complete
--

