PGDMP  -    1                |           Terminal    16.3    16.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    41083    Terminal    DATABASE     }   CREATE DATABASE "Terminal" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "Terminal";
                postgres    false            �            1259    41102    Omnibus    TABLE     f  CREATE TABLE public."Omnibus" (
    matricula character varying NOT NULL,
    marca character varying NOT NULL,
    modelo character varying NOT NULL,
    destino character varying NOT NULL,
    capacidad integer NOT NULL,
    hora_salida time(0) without time zone NOT NULL,
    pais_procedencia character varying NOT NULL,
    id_taller integer NOT NULL
);
    DROP TABLE public."Omnibus";
       public         heap    postgres    false            �          0    41102    Omnibus 
   TABLE DATA           {   COPY public."Omnibus" (matricula, marca, modelo, destino, capacidad, hora_salida, pais_procedencia, id_taller) FROM stdin;
    public          postgres    false    215   �       $           2606    41267    Omnibus Matricula 
   CONSTRAINT     Z   ALTER TABLE ONLY public."Omnibus"
    ADD CONSTRAINT "Matricula" PRIMARY KEY (matricula);
 ?   ALTER TABLE ONLY public."Omnibus" DROP CONSTRAINT "Matricula";
       public            postgres    false    215            %           2606    41135    Omnibus idTaller    FK CONSTRAINT     �   ALTER TABLE ONLY public."Omnibus"
    ADD CONSTRAINT "idTaller" FOREIGN KEY (id_taller) REFERENCES public."Taller"(id_taller) NOT VALID;
 >   ALTER TABLE ONLY public."Omnibus" DROP CONSTRAINT "idTaller";
       public          postgres    false    215            �   �  x�u�Kn�0���)8Ae�$ˤj�h��YU�fZ�1� WJv=PN��u��p�v<����?Ɓ#9�n�=��b�	_O��fK��a��,�Y�lyQ��+���+<�xP�0|��R�*�o��e�ٝ��� �[T�X��&�m-PՕ6�j�WQfi�ygD#��ysn8/.��D^�O�7�D��d�Ӟ�`pQ��L.�6WEq$#��9x/���W<�f�f�E��]�x��q��k�T�JuU�ey�l�NڬK���W�EQ6����y+�S#��	�G�@�G���?r1����A梣�����l%���W=dcy,����z��Gl�t�i;�-z@c���x�ݢ�ϙ�{j��]�l�b�d�d�ך�m�k����s���l��� ~ ~��     