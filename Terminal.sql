PGDMP                      |           Terminal    16.3    16.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    41083    Terminal    DATABASE     }   CREATE DATABASE "Terminal" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "Terminal";
                postgres    false            �            1259    41102    Omnibus    TABLE     ~  CREATE TABLE public."Omnibus" (
    "Matricula" character varying(7) NOT NULL,
    "Marca" character varying NOT NULL,
    "Modelo" character varying NOT NULL,
    "Destino" character varying NOT NULL,
    "Capacidad" integer NOT NULL,
    "Hora de Salida" time(0) without time zone NOT NULL,
    "Pais de Procedencia" character varying NOT NULL,
    "idTaller" integer NOT NULL
);
    DROP TABLE public."Omnibus";
       public         heap    postgres    false            �          0    41102    Omnibus 
   TABLE DATA           �   COPY public."Omnibus" ("Matricula", "Marca", "Modelo", "Destino", "Capacidad", "Hora de Salida", "Pais de Procedencia", "idTaller") FROM stdin;
    public          postgres    false    217   	       $           2606    41108    Omnibus Matricula 
   CONSTRAINT     \   ALTER TABLE ONLY public."Omnibus"
    ADD CONSTRAINT "Matricula" PRIMARY KEY ("Matricula");
 ?   ALTER TABLE ONLY public."Omnibus" DROP CONSTRAINT "Matricula";
       public            postgres    false    217            %           2606    41135    Omnibus idTaller    FK CONSTRAINT     �   ALTER TABLE ONLY public."Omnibus"
    ADD CONSTRAINT "idTaller" FOREIGN KEY ("idTaller") REFERENCES public."Taller"("idTaller") NOT VALID;
 >   ALTER TABLE ONLY public."Omnibus" DROP CONSTRAINT "idTaller";
       public          postgres    false    217            �      x������ � �     