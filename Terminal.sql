PGDMP  /    *                |           Terminal    16.3    16.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    41083    Terminal    DATABASE     }   CREATE DATABASE "Terminal" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "Terminal";
                postgres    false            �            1259    41115 	   Conductor    TABLE       CREATE TABLE public."Conductor" (
    id_conductor integer NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    direccion character varying NOT NULL,
    telefono character varying NOT NULL,
    matricula character varying NOT NULL
);
    DROP TABLE public."Conductor";
       public         heap    postgres    false            �            1259    41114    Conductor_IdConductor_seq    SEQUENCE     �   CREATE SEQUENCE public."Conductor_IdConductor_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public."Conductor_IdConductor_seq";
       public          postgres    false    217            �           0    0    Conductor_IdConductor_seq    SEQUENCE OWNED BY     \   ALTER SEQUENCE public."Conductor_IdConductor_seq" OWNED BY public."Conductor".id_conductor;
          public          postgres    false    216            �            1259    41102    Omnibus    TABLE     �  CREATE TABLE public."Omnibus" (
    matricula character varying NOT NULL,
    marca character varying NOT NULL,
    modelo character varying NOT NULL,
    destino character varying NOT NULL,
    capacidad integer NOT NULL,
    hora_salida time(0) without time zone NOT NULL,
    pais_procedencia character varying NOT NULL,
    id_taller integer NOT NULL,
    disponible boolean DEFAULT true NOT NULL
);
    DROP TABLE public."Omnibus";
       public         heap    postgres    false            �            1259    41128    Taller    TABLE     �   CREATE TABLE public."Taller" (
    id_taller integer NOT NULL,
    nombre character varying NOT NULL,
    direccion character varying NOT NULL,
    telefono character varying NOT NULL
);
    DROP TABLE public."Taller";
       public         heap    postgres    false            �            1259    41253    Ticket    TABLE     B  CREATE TABLE public."Ticket" (
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
          public          postgres    false    219            (           2604    41118    Conductor id_conductor    DEFAULT     �   ALTER TABLE ONLY public."Conductor" ALTER COLUMN id_conductor SET DEFAULT nextval('public."Conductor_IdConductor_seq"'::regclass);
 G   ALTER TABLE public."Conductor" ALTER COLUMN id_conductor DROP DEFAULT;
       public          postgres    false    217    216    217            )           2604    41256    Ticket id_ticket    DEFAULT     x   ALTER TABLE ONLY public."Ticket" ALTER COLUMN id_ticket SET DEFAULT nextval('public."Ticket_id_ticket_seq"'::regclass);
 A   ALTER TABLE public."Ticket" ALTER COLUMN id_ticket DROP DEFAULT;
       public          postgres    false    219    220    220            �          0    41115 	   Conductor 
   TABLE DATA           e   COPY public."Conductor" (id_conductor, nombre, apellido, direccion, telefono, matricula) FROM stdin;
    public          postgres    false    217   �        �          0    41102    Omnibus 
   TABLE DATA           �   COPY public."Omnibus" (matricula, marca, modelo, destino, capacidad, hora_salida, pais_procedencia, id_taller, disponible) FROM stdin;
    public          postgres    false    215   (!       �          0    41128    Taller 
   TABLE DATA           J   COPY public."Taller" (id_taller, nombre, direccion, telefono) FROM stdin;
    public          postgres    false    218   #       �          0    41253    Ticket 
   TABLE DATA           �   COPY public."Ticket" (id_ticket, nombre_pasajero, apellidos_pasajero, ci_pasajero, fecha_salida, destino, matricula) FROM stdin;
    public          postgres    false    220   V#       �           0    0    Conductor_IdConductor_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public."Conductor_IdConductor_seq"', 16, true);
          public          postgres    false    216            �           0    0    Ticket_id_ticket_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public."Ticket_id_ticket_seq"', 27, true);
          public          postgres    false    219            -           2606    41122    Conductor Conductor_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public."Conductor"
    ADD CONSTRAINT "Conductor_pkey" PRIMARY KEY (id_conductor);
 F   ALTER TABLE ONLY public."Conductor" DROP CONSTRAINT "Conductor_pkey";
       public            postgres    false    217            +           2606    41267    Omnibus Matricula 
   CONSTRAINT     Z   ALTER TABLE ONLY public."Omnibus"
    ADD CONSTRAINT "Matricula" PRIMARY KEY (matricula);
 ?   ALTER TABLE ONLY public."Omnibus" DROP CONSTRAINT "Matricula";
       public            postgres    false    215            /           2606    41134    Taller Taller_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public."Taller"
    ADD CONSTRAINT "Taller_pkey" PRIMARY KEY (id_taller);
 @   ALTER TABLE ONLY public."Taller" DROP CONSTRAINT "Taller_pkey";
       public            postgres    false    218            1           2606    41260    Ticket id_ticket 
   CONSTRAINT     W   ALTER TABLE ONLY public."Ticket"
    ADD CONSTRAINT id_ticket PRIMARY KEY (id_ticket);
 <   ALTER TABLE ONLY public."Ticket" DROP CONSTRAINT id_ticket;
       public            postgres    false    220            3           2606    41281    Conductor Matricula    FK CONSTRAINT     �   ALTER TABLE ONLY public."Conductor"
    ADD CONSTRAINT "Matricula" FOREIGN KEY (matricula) REFERENCES public."Omnibus"(matricula);
 A   ALTER TABLE ONLY public."Conductor" DROP CONSTRAINT "Matricula";
       public          postgres    false    217    4651    215            2           2606    41135    Omnibus idTaller    FK CONSTRAINT     �   ALTER TABLE ONLY public."Omnibus"
    ADD CONSTRAINT "idTaller" FOREIGN KEY (id_taller) REFERENCES public."Taller"(id_taller) NOT VALID;
 >   ALTER TABLE ONLY public."Omnibus" DROP CONSTRAINT "idTaller";
       public          postgres    false    218    4655    215            4           2606    41273    Ticket matricula    FK CONSTRAINT     ~   ALTER TABLE ONLY public."Ticket"
    ADD CONSTRAINT matricula FOREIGN KEY (matricula) REFERENCES public."Omnibus"(matricula);
 <   ALTER TABLE ONLY public."Ticket" DROP CONSTRAINT matricula;
       public          postgres    false    4651    215    220            �   x   x�%���0Dg�c*G$$R�N|@��*W����io�;�ݹ =OE���/v�BCD�y�ń���3\ו��Oַ��]�	]7u�z��I/�"E6Cۜ�'�&Ĕ=>.�x�.#P      �   �  x�uRKn�0]�N��>��]�~�&A-���i%R�J0� ���)|���h9v;C)�o��u�v�3z�|
wqQ�xsxi!�\b��)$YJ��d�4u-@pù������-�_�����e'z�!�'����%!����U�C�8<���g����}�%@����	�n��D�[�=>�y�;��U�,w�2x@f�`6'6��	�G���e�c;t�ۘ�~���ޯ>�vu}�^~�L�� ���u�R������ﰹ�%�����d�1z���xš�����I�x�Y��A`Xg-��R�H5 ���{X>��	�T�X�R����&����aX�9���u�n�B��t8�N=����z�$�|6_dP ���$S��#��<�O����o��5�c��¸{}���]���d�K��6:+����u?t���	�i%7BAjy��ޡf�U�
�o�(��x�      �   E   x�3216��MM�H��LN�Q��)-����tN,*J-I-JTpN�+)J)�p�r��qqq r��      �   u  x��RAN#1<�_�d����c )YD�hÑK���c#'���8��|l{ 	H�[򩪫�F��ה���v�/�3�y.;��*T�r6��f����� O��v��f�Y����>�3�P) ꪶ�m�
����WYv^����B�B+H�&T�������]+tמx}N;O���`k�ŀn�7�0����&?�=0�1u���?���q�Yd/羰��!�k̩C=�xKHTX"�_!���{p����Z��y��>s/�;��L�������kl[��Gy,4)�	����K���ŗ�߀-�2<q ~yvk� ���U�e�rF���3߅b$y���+m��th\���&U;R7$�tO��a#�~!�+;��     