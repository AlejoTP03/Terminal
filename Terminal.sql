PGDMP  &    +                |           Terminal    16.3    16.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    41083    Terminal    DATABASE     }   CREATE DATABASE "Terminal" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "Terminal";
                postgres    false            �            1259    41253    Ticket    TABLE     B  CREATE TABLE public."Ticket" (
    id_ticket integer NOT NULL,
    nombre_pasajero character varying NOT NULL,
    apellidos_pasajero character varying NOT NULL,
    ci_pasajero character varying NOT NULL,
    fecha_salida date NOT NULL,
    destino character varying NOT NULL,
    matricula character varying NOT NULL
);
    DROP TABLE public."Ticket";
       public         heap    postgres    false            �            1259    41252    Ticket_id_ticket_seq    SEQUENCE     �   CREATE SEQUENCE public."Ticket_id_ticket_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public."Ticket_id_ticket_seq";
       public          postgres    false    220            �           0    0    Ticket_id_ticket_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public."Ticket_id_ticket_seq" OWNED BY public."Ticket".id_ticket;
          public          postgres    false    219            #           2604    41256    Ticket id_ticket    DEFAULT     x   ALTER TABLE ONLY public."Ticket" ALTER COLUMN id_ticket SET DEFAULT nextval('public."Ticket_id_ticket_seq"'::regclass);
 A   ALTER TABLE public."Ticket" ALTER COLUMN id_ticket DROP DEFAULT;
       public          postgres    false    219    220    220            �          0    41253    Ticket 
   TABLE DATA           �   COPY public."Ticket" (id_ticket, nombre_pasajero, apellidos_pasajero, ci_pasajero, fecha_salida, destino, matricula) FROM stdin;
    public          postgres    false    220   "       �           0    0    Ticket_id_ticket_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public."Ticket_id_ticket_seq"', 27, true);
          public          postgres    false    219            %           2606    41260    Ticket id_ticket 
   CONSTRAINT     W   ALTER TABLE ONLY public."Ticket"
    ADD CONSTRAINT id_ticket PRIMARY KEY (id_ticket);
 <   ALTER TABLE ONLY public."Ticket" DROP CONSTRAINT id_ticket;
       public            postgres    false    220            &           2606    41273    Ticket matricula    FK CONSTRAINT     ~   ALTER TABLE ONLY public."Ticket"
    ADD CONSTRAINT matricula FOREIGN KEY (matricula) REFERENCES public."Omnibus"(matricula);
 <   ALTER TABLE ONLY public."Ticket" DROP CONSTRAINT matricula;
       public          postgres    false    220            �   �  x���AN�0���S�E�c���T@T�^��m��U�9	�q ��{���
��������gK���169�߶_>�䳔; 
)DaYiPB�T0Ǹ�<�?�޲���f�Y�=�5ܸ�"Lq�}@R���:%�ޭo߽>��p%)����K�4��S?إ�5S�9��)vW}����l U?��.B����@�J�uE�o��.�ƻ@![>s�"�T��G�jTP1SD�|:T�zZాV�(Y�ڋ�w��@|�)C�@is�M����ԥ6J£�I�����S%�]����HπF�'d�`����ڍދ)c�!�0I��3��W�(:�[l�ދI���K��cOئ��ч���w�w�� X�mU���HH�G~��G��w����§     