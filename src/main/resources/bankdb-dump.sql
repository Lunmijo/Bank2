--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11.1

-- Started on 2019-02-12 22:33:48

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 593 (class 1247 OID 16538)
-- Name: currency; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.currency AS ENUM (
    'UAH',
    'USD',
    'EUR'
);


ALTER TYPE public.currency OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 33055)
-- Name: bank_accounts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bank_accounts (
    id bigint NOT NULL,
    currency text NOT NULL,
    availablemoney double precision NOT NULL
);


ALTER TABLE public.bank_accounts OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 33047)
-- Name: currencyrates; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.currencyrates (
    date text NOT NULL,
    uahtousd double precision NOT NULL,
    uahtoeur double precision NOT NULL,
    usdtouah double precision NOT NULL,
    eurtouah double precision NOT NULL,
    eurtousd double precision NOT NULL,
    usdtoeur double precision NOT NULL
);


ALTER TABLE public.currencyrates OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 33114)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 33063)
-- Name: transactions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transactions (
    id bigint NOT NULL,
    sender bigint NOT NULL,
    receiver bigint,
    sum double precision NOT NULL,
    currency text NOT NULL
);


ALTER TABLE public.transactions OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 33081)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    firstname text NOT NULL,
    lastname text NOT NULL,
    accountuah bigint,
    accountusd bigint,
    accounteur bigint
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 2839 (class 0 OID 33055)
-- Dependencies: 197
-- Data for Name: bank_accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bank_accounts (id, currency, availablemoney) FROM stdin;
\.


--
-- TOC entry 2838 (class 0 OID 33047)
-- Dependencies: 196
-- Data for Name: currencyrates; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.currencyrates (date, uahtousd, uahtoeur, usdtouah, eurtouah, eurtousd, usdtoeur) FROM stdin;
1	0.299999999999999989	0.320000000000000007	30	32	1.1399999999999999	1.15999999999999992
\.


--
-- TOC entry 2840 (class 0 OID 33063)
-- Dependencies: 198
-- Data for Name: transactions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transactions (id, sender, receiver, sum, currency) FROM stdin;
\.


--
-- TOC entry 2841 (class 0 OID 33081)
-- Dependencies: 199
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, firstname, lastname, accountuah, accountusd, accounteur) FROM stdin;
\.


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 200
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 29, true);


--
-- TOC entry 2707 (class 2606 OID 33062)
-- Name: bank_accounts bank_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bank_accounts
    ADD CONSTRAINT bank_accounts_pkey PRIMARY KEY (id);


--
-- TOC entry 2705 (class 2606 OID 33054)
-- Name: currencyrates currencyrates_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.currencyrates
    ADD CONSTRAINT currencyrates_pkey PRIMARY KEY (date);


--
-- TOC entry 2709 (class 2606 OID 33070)
-- Name: transactions transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (id);


--
-- TOC entry 2711 (class 2606 OID 33088)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2716 (class 2606 OID 33099)
-- Name: users eur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT eur FOREIGN KEY (accounteur) REFERENCES public.bank_accounts(id);


--
-- TOC entry 2712 (class 2606 OID 33121)
-- Name: transactions receiverid; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT receiverid FOREIGN KEY (receiver) REFERENCES public.bank_accounts(id);


--
-- TOC entry 2713 (class 2606 OID 33116)
-- Name: transactions senderid; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT senderid FOREIGN KEY (sender) REFERENCES public.bank_accounts(id);


--
-- TOC entry 2714 (class 2606 OID 33089)
-- Name: users uah; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uah FOREIGN KEY (accountuah) REFERENCES public.bank_accounts(id);


--
-- TOC entry 2715 (class 2606 OID 33094)
-- Name: users usd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT usd FOREIGN KEY (accountusd) REFERENCES public.bank_accounts(id);


-- Completed on 2019-02-12 22:33:48

--
-- PostgreSQL database dump complete
--

