PGDMP  4        	            |           Terminal    16.3    16.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    41083    Terminal    DATABASE     }   CREATE DATABASE "Terminal" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "Terminal";
                postgres    false            �            1259    41115 	   Conductor    TABLE       CREATE TABLE public."Conductor" (
    id_conductor integer NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    direccion character varying NOT NULL,
    telefono character varying NOT NULL,
    matricula character varying(7) NOT NULL
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
          public          postgres    false    216            #           2604    41118    Conductor id_conductor    DEFAULT     �   ALTER TABLE ONLY public."Conductor" ALTER COLUMN id_conductor SET DEFAULT nextval('public."Conductor_IdConductor_seq"'::regclass);
 G   ALTER TABLE public."Conductor" ALTER COLUMN id_conductor DROP DEFAULT;
       public          postgres    false    217    216    217            �          0    41115 	   Conductor 
   TABLE DATA           e   COPY public."Conductor" (id_conductor, nombre, apellido, direccion, telefono, matricula) FROM stdin;
    public          postgres    false    217   P       �           0    0    Conductor_IdConductor_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public."Conductor_IdConductor_seq"', 10, true);
          public          postgres    false    216            %           2606    41122    Conductor Conductor_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public."Conductor"
    ADD CONSTRAINT "Conductor_pkey" PRIMARY KEY (id_conductor);
 F   ALTER TABLE ONLY public."Conductor" DROP CONSTRAINT "Conductor_pkey";
       public            postgres    false    217            &           2606    41268    Conductor Matricula    FK CONSTRAINT     �   ALTER TABLE ONLY public."Conductor"
    ADD CONSTRAINT "Matricula" FOREIGN KEY (matricula) REFERENCES public."Omnibus"(matricula);
 A   ALTER TABLE ONLY public."Conductor" DROP CONSTRAINT "Matricula";
       public          postgres    false    217            �     x�u�Oo�0��Χ��M�i��ۤJv��m�d1s�K?�L�N�4G�#���7��˰�ka�����P ���+8cw����w�`�Rf+�=X�xv��l�w�D��LB���!�~���1��%�-B���A>Y����S�'&WU���'A�j��ἧ�e��6N\�u7�a���|W�^���5�P��s���7.^,n9q�~�g=?�V�PrH�5�A�DtC�pqd�q���Ɠ���=7�O�uKB��$�>���x<�|>c~ ��E     