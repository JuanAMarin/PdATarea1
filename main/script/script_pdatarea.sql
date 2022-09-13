PGDMP     4    )                z            postgres    14.5    14.5 1    8           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            9           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            :           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ;           1262    13754    postgres    DATABASE     f   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Uruguay.1252';
    DROP DATABASE postgres;
                postgres    false            <           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3387                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            =           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            �            1259    17549    actividaddep    TABLE     �   CREATE TABLE public.actividaddep (
    nombre character varying(255) NOT NULL,
    costo real NOT NULL,
    descripcion character varying(255),
    duracion integer,
    fecha timestamp without time zone
);
     DROP TABLE public.actividaddep;
       public         heap    postgres    false            �            1259    17554    actividaddep_clase    TABLE     �   CREATE TABLE public.actividaddep_clase (
    actividaddep_nombre character varying(255) NOT NULL,
    clases_nombre character varying(255) NOT NULL
);
 &   DROP TABLE public.actividaddep_clase;
       public         heap    postgres    false            �            1259    17559    clase    TABLE     �   CREATE TABLE public.clase (
    nombre character varying(255) NOT NULL,
    fecha timestamp without time zone,
    fechareg timestamp without time zone,
    horainicio timestamp without time zone,
    url character varying(255)
);
    DROP TABLE public.clase;
       public         heap    postgres    false            �            1259    17564    instituciondep    TABLE     �   CREATE TABLE public.instituciondep (
    nombre character varying(255) NOT NULL,
    descripcion character varying(255),
    url character varying(255)
);
 "   DROP TABLE public.instituciondep;
       public         heap    postgres    false            �            1259    17569    instituciondep_actividaddep    TABLE     �   CREATE TABLE public.instituciondep_actividaddep (
    instituciondep_nombre character varying(255) NOT NULL,
    actividades_nombre character varying(255) NOT NULL
);
 /   DROP TABLE public.instituciondep_actividaddep;
       public         heap    postgres    false            �            1259    17574    profesor    TABLE     �   CREATE TABLE public.profesor (
    biografia character varying(255),
    descripcion character varying(255),
    sitioweb character varying(255),
    nickname character varying(255) NOT NULL,
    insti character varying(255)
);
    DROP TABLE public.profesor;
       public         heap    postgres    false            �            1259    17579    profesor_clase    TABLE     �   CREATE TABLE public.profesor_clase (
    profesor_nickname character varying(255) NOT NULL,
    clases_nombre character varying(255) NOT NULL
);
 "   DROP TABLE public.profesor_clase;
       public         heap    postgres    false            �            1259    17584    registro    TABLE     �   CREATE TABLE public.registro (
    fechareg date,
    clase_nombre character varying(255) NOT NULL,
    socio_nickname character varying(255) NOT NULL
);
    DROP TABLE public.registro;
       public         heap    postgres    false            �            1259    17589    socio    TABLE     L   CREATE TABLE public.socio (
    nickname character varying(255) NOT NULL
);
    DROP TABLE public.socio;
       public         heap    postgres    false            �            1259    17592    usuario    TABLE     �   CREATE TABLE public.usuario (
    nickname character varying(255) NOT NULL,
    apellido character varying(255),
    email character varying(255),
    fechanac timestamp without time zone,
    nombre character varying(255)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            ,          0    17549    actividaddep 
   TABLE DATA           S   COPY public.actividaddep (nombre, costo, descripcion, duracion, fecha) FROM stdin;
    public          postgres    false    210   �<       -          0    17554    actividaddep_clase 
   TABLE DATA           P   COPY public.actividaddep_clase (actividaddep_nombre, clases_nombre) FROM stdin;
    public          postgres    false    211   ,>       .          0    17559    clase 
   TABLE DATA           I   COPY public.clase (nombre, fecha, fechareg, horainicio, url) FROM stdin;
    public          postgres    false    212   �>       /          0    17564    instituciondep 
   TABLE DATA           B   COPY public.instituciondep (nombre, descripcion, url) FROM stdin;
    public          postgres    false    213   �?       0          0    17569    instituciondep_actividaddep 
   TABLE DATA           `   COPY public.instituciondep_actividaddep (instituciondep_nombre, actividades_nombre) FROM stdin;
    public          postgres    false    214   �@       1          0    17574    profesor 
   TABLE DATA           U   COPY public.profesor (biografia, descripcion, sitioweb, nickname, insti) FROM stdin;
    public          postgres    false    215   9A       2          0    17579    profesor_clase 
   TABLE DATA           J   COPY public.profesor_clase (profesor_nickname, clases_nombre) FROM stdin;
    public          postgres    false    216   QB       3          0    17584    registro 
   TABLE DATA           J   COPY public.registro (fechareg, clase_nombre, socio_nickname) FROM stdin;
    public          postgres    false    217   �B       4          0    17589    socio 
   TABLE DATA           )   COPY public.socio (nickname) FROM stdin;
    public          postgres    false    218   C       5          0    17592    usuario 
   TABLE DATA           N   COPY public.usuario (nickname, apellido, email, fechanac, nombre) FROM stdin;
    public          postgres    false    219   IC       �           2606    17598    actividaddep actividaddep_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.actividaddep
    ADD CONSTRAINT actividaddep_pkey PRIMARY KEY (nombre);
 H   ALTER TABLE ONLY public.actividaddep DROP CONSTRAINT actividaddep_pkey;
       public            postgres    false    210            �           2606    17600    clase clase_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.clase
    ADD CONSTRAINT clase_pkey PRIMARY KEY (nombre);
 :   ALTER TABLE ONLY public.clase DROP CONSTRAINT clase_pkey;
       public            postgres    false    212            �           2606    17602 "   instituciondep instituciondep_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.instituciondep
    ADD CONSTRAINT instituciondep_pkey PRIMARY KEY (nombre);
 L   ALTER TABLE ONLY public.instituciondep DROP CONSTRAINT instituciondep_pkey;
       public            postgres    false    213            �           2606    17604    profesor profesor_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (nickname);
 @   ALTER TABLE ONLY public.profesor DROP CONSTRAINT profesor_pkey;
       public            postgres    false    215            �           2606    17606    registro registro_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.registro
    ADD CONSTRAINT registro_pkey PRIMARY KEY (clase_nombre, socio_nickname);
 @   ALTER TABLE ONLY public.registro DROP CONSTRAINT registro_pkey;
       public            postgres    false    217    217            �           2606    17608    socio socio_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.socio
    ADD CONSTRAINT socio_pkey PRIMARY KEY (nickname);
 :   ALTER TABLE ONLY public.socio DROP CONSTRAINT socio_pkey;
       public            postgres    false    218            �           2606    17610 /   actividaddep_clase uk_14lxf26lqla40dpfqwjf0jcj1 
   CONSTRAINT     s   ALTER TABLE ONLY public.actividaddep_clase
    ADD CONSTRAINT uk_14lxf26lqla40dpfqwjf0jcj1 UNIQUE (clases_nombre);
 Y   ALTER TABLE ONLY public.actividaddep_clase DROP CONSTRAINT uk_14lxf26lqla40dpfqwjf0jcj1;
       public            postgres    false    211            �           2606    17612 $   usuario uk_4tdehxj7dh8ghfc68kbwbsbll 
   CONSTRAINT     `   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT uk_4tdehxj7dh8ghfc68kbwbsbll UNIQUE (email);
 N   ALTER TABLE ONLY public.usuario DROP CONSTRAINT uk_4tdehxj7dh8ghfc68kbwbsbll;
       public            postgres    false    219            �           2606    17614 +   profesor_clase uk_pbrvheukqpfqoermg6elvys3x 
   CONSTRAINT     o   ALTER TABLE ONLY public.profesor_clase
    ADD CONSTRAINT uk_pbrvheukqpfqoermg6elvys3x UNIQUE (clases_nombre);
 U   ALTER TABLE ONLY public.profesor_clase DROP CONSTRAINT uk_pbrvheukqpfqoermg6elvys3x;
       public            postgres    false    216            �           2606    17616 8   instituciondep_actividaddep uk_r9ilh8ekculc5jgeyrolw9vq9 
   CONSTRAINT     �   ALTER TABLE ONLY public.instituciondep_actividaddep
    ADD CONSTRAINT uk_r9ilh8ekculc5jgeyrolw9vq9 UNIQUE (actividades_nombre);
 b   ALTER TABLE ONLY public.instituciondep_actividaddep DROP CONSTRAINT uk_r9ilh8ekculc5jgeyrolw9vq9;
       public            postgres    false    214            �           2606    17618    usuario usuario_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (nickname);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    219            �           2606    17619 $   profesor fk24h8fh7lxifbnrkx3nvfifovq    FK CONSTRAINT     �   ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT fk24h8fh7lxifbnrkx3nvfifovq FOREIGN KEY (insti) REFERENCES public.instituciondep(nombre);
 N   ALTER TABLE ONLY public.profesor DROP CONSTRAINT fk24h8fh7lxifbnrkx3nvfifovq;
       public          postgres    false    213    3207    215            �           2606    17624 *   profesor_clase fk2aac3bddvlnidy27waodre1um    FK CONSTRAINT     �   ALTER TABLE ONLY public.profesor_clase
    ADD CONSTRAINT fk2aac3bddvlnidy27waodre1um FOREIGN KEY (clases_nombre) REFERENCES public.clase(nombre);
 T   ALTER TABLE ONLY public.profesor_clase DROP CONSTRAINT fk2aac3bddvlnidy27waodre1um;
       public          postgres    false    212    216    3205            �           2606    17629 .   actividaddep_clase fk2sy50fin1tomnardpm2armow1    FK CONSTRAINT     �   ALTER TABLE ONLY public.actividaddep_clase
    ADD CONSTRAINT fk2sy50fin1tomnardpm2armow1 FOREIGN KEY (actividaddep_nombre) REFERENCES public.actividaddep(nombre);
 X   ALTER TABLE ONLY public.actividaddep_clase DROP CONSTRAINT fk2sy50fin1tomnardpm2armow1;
       public          postgres    false    210    3201    211            �           2606    17634 7   instituciondep_actividaddep fkb90v0ldmwe623cua5icyyvqv3    FK CONSTRAINT     �   ALTER TABLE ONLY public.instituciondep_actividaddep
    ADD CONSTRAINT fkb90v0ldmwe623cua5icyyvqv3 FOREIGN KEY (instituciondep_nombre) REFERENCES public.instituciondep(nombre);
 a   ALTER TABLE ONLY public.instituciondep_actividaddep DROP CONSTRAINT fkb90v0ldmwe623cua5icyyvqv3;
       public          postgres    false    3207    213    214            �           2606    17639 *   profesor_clase fkbs6ftqwrke02q02rj9euu8v0n    FK CONSTRAINT     �   ALTER TABLE ONLY public.profesor_clase
    ADD CONSTRAINT fkbs6ftqwrke02q02rj9euu8v0n FOREIGN KEY (profesor_nickname) REFERENCES public.profesor(nickname);
 T   ALTER TABLE ONLY public.profesor_clase DROP CONSTRAINT fkbs6ftqwrke02q02rj9euu8v0n;
       public          postgres    false    3211    216    215            �           2606    17644 $   profesor fkfmvyi0mm448f3rx54cop3crka    FK CONSTRAINT     �   ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT fkfmvyi0mm448f3rx54cop3crka FOREIGN KEY (nickname) REFERENCES public.usuario(nickname);
 N   ALTER TABLE ONLY public.profesor DROP CONSTRAINT fkfmvyi0mm448f3rx54cop3crka;
       public          postgres    false    3221    219    215            �           2606    17649 7   instituciondep_actividaddep fkfr8lgektt8jl0x8f554nwmnty    FK CONSTRAINT     �   ALTER TABLE ONLY public.instituciondep_actividaddep
    ADD CONSTRAINT fkfr8lgektt8jl0x8f554nwmnty FOREIGN KEY (actividades_nombre) REFERENCES public.actividaddep(nombre);
 a   ALTER TABLE ONLY public.instituciondep_actividaddep DROP CONSTRAINT fkfr8lgektt8jl0x8f554nwmnty;
       public          postgres    false    210    214    3201            �           2606    17654 !   socio fkg97fl0x1xc272pyxkmtr9tp7m    FK CONSTRAINT     �   ALTER TABLE ONLY public.socio
    ADD CONSTRAINT fkg97fl0x1xc272pyxkmtr9tp7m FOREIGN KEY (nickname) REFERENCES public.usuario(nickname);
 K   ALTER TABLE ONLY public.socio DROP CONSTRAINT fkg97fl0x1xc272pyxkmtr9tp7m;
       public          postgres    false    3221    219    218            �           2606    17659 .   actividaddep_clase fkk8484kf0berh23tjfg5eabrjh    FK CONSTRAINT     �   ALTER TABLE ONLY public.actividaddep_clase
    ADD CONSTRAINT fkk8484kf0berh23tjfg5eabrjh FOREIGN KEY (clases_nombre) REFERENCES public.clase(nombre);
 X   ALTER TABLE ONLY public.actividaddep_clase DROP CONSTRAINT fkk8484kf0berh23tjfg5eabrjh;
       public          postgres    false    212    211    3205            �           2606    17664 $   registro fkmqtgad4smv5v7m0ytdnwl4cm2    FK CONSTRAINT     �   ALTER TABLE ONLY public.registro
    ADD CONSTRAINT fkmqtgad4smv5v7m0ytdnwl4cm2 FOREIGN KEY (socio_nickname) REFERENCES public.socio(nickname);
 N   ALTER TABLE ONLY public.registro DROP CONSTRAINT fkmqtgad4smv5v7m0ytdnwl4cm2;
       public          postgres    false    3217    217    218            �           2606    17669 $   registro fkn9b8923qkevyxe6mnnfp36661    FK CONSTRAINT     �   ALTER TABLE ONLY public.registro
    ADD CONSTRAINT fkn9b8923qkevyxe6mnnfp36661 FOREIGN KEY (clase_nombre) REFERENCES public.clase(nombre);
 N   ALTER TABLE ONLY public.registro DROP CONSTRAINT fkn9b8923qkevyxe6mnnfp36661;
       public          postgres    false    217    3205    212            ,   K  x�e�AN�0E��)fî��EmvU�z6�x SǓ:�b�8B/�8�RW���ϼ?�>�̤����"�	�3.ZRFm�Z�֍�f׵���n�:�t�|�T���L	�H�3E� ���Ǧ��z�m�����>@� M0Gp4r�k���x:�~�����91�ϯ�8��G�b�3��(��'5%[�!�Ē��S_���������(�"]�� �F�
^8e��� e(v?�e �%Nƞk��_�ѝn�V���V%E��Ā�ʖ}>�0R������ �̐(:?x�"���'8�@>�N4^�D�ӌY���=�UU�8���      -   R   x�-���0�3L�N���Ԋ"�&n���PR_d�3nWoR��~�\`F�c�� ׶��i�b���Ѱɪ�&x����"{      .   M  x�]��j�0���SC�Ō''ښ�.�ѷ�3Mm65b"]o��e�Z���󇜏�co�&�Zrn����L���Tb�8gP��}���$�+.R�bX+�P����SY���Og�v�;����e���t�zk�%2�G�\	�$�2G%r����%�ڱ��4��1;6��e[jm_i���V^��]� �_�d�I	I��c��ːI����E������.��4�����9��B�!�`��"�]h��!��!_d�X[g��YGce��e�hd�ESCcLm|0��J0SU��R�:��(�~����4ͼ�l�]�P4��")��EQ����      /   �   x�U�Mk�0��~
=t�IԸZ���16<� X�寉/`�Ĩ�>�
�l����q� Fn��Ռ�U+ɸ2z���о�|w�!S���Q>�<+�OwRv#w)��yAw�pTܿC��l::�;��4������J�����b�!��پ 6Y�5�Q{
���6j(m���S�LkAP{j��@\=m����g�ZT���¤�BE����<�:uo�k�y��߮i����YW      0   G   x�5ȱ�0�:��0�E����HlO����P��d����[V���aG	�����B	�y�;�V      1     x�=P9n�0��W�Jg��3
`�#���6&�I;ɣR�	�Xd��)sDѕ�qB�H������&�3�8eVs���P1�|�D�����J� �ă�kE���(�ccqD�ES�רn%c��ޓ��j��?'�=�1��6�l�X�>��D�"&�B�@e���Q��y8�����]�^��~k>��L7.,�R�T��V6KZ�Lu�;�����AOv<��u��]�����Ϋ���_G*���]*��ql�M�4w      2   I   x�K��M,I����/���KWH�I,.�J������A�*�3J�8�2�3JP��J��s�2�2K�b���� ���      3   T   x�3202�5��54�����SH�I,.����K�2�*��*�U��X��������Y��YQQ��W�YP�_��X�ZN�������� �� �      4   +   x����K�J⊊�ļ�̂������Ԣ�̴Ċ
�=... �      5     x�]��n�0���S�D8%Pr�Ҥj;���iI��o��i�N��N����|P��0�z3�}�)^�{?��*Q"�x*��Z�3��-�rLۉ��j�wZ��c��֯$,sՙ$%�WR&�`{WrY�8x�����7I%��N�Va͛��[Zfi��@�у��і~�^!�!!
Q)<���m�۶Hn1s�]���Ӷ�[V	}0q\9VGvX/q���:�ޔ>�N��,�=nHu���3����g�� �"v�     