PGDMP     #                    y            d474c8ru70ineb     13.2 (Ubuntu 13.2-1.pgdg20.04+1)    13.0 6    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    24602    d474c8ru70ineb    DATABASE     c   CREATE DATABASE d474c8ru70ineb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';
    DROP DATABASE d474c8ru70ineb;
                tkwxxlnxscfswo    false            ?           0    0    DATABASE d474c8ru70ineb    ACL     A   REVOKE CONNECT,TEMPORARY ON DATABASE d474c8ru70ineb FROM PUBLIC;
                   tkwxxlnxscfswo    false    4043            ?           0    0    SCHEMA public    ACL     ?   REVOKE ALL ON SCHEMA public FROM postgres;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO tkwxxlnxscfswo;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   tkwxxlnxscfswo    false    5            ?           0    0    LANGUAGE plpgsql    ACL     1   GRANT ALL ON LANGUAGE plpgsql TO tkwxxlnxscfswo;
                   postgres    false    664            ?            1259    25836    especialidad    TABLE     ?   CREATE TABLE public.especialidad (
    espe_id integer NOT NULL,
    espe_nombre text,
    espe_precio double precision,
    espe_vigente boolean
);
     DROP TABLE public.especialidad;
       public         heap    tkwxxlnxscfswo    false            ?            1259    25842    especialidad_espe_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.especialidad_espe_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.especialidad_espe_id_seq;
       public          tkwxxlnxscfswo    false    200            ?           0    0    especialidad_espe_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.especialidad_espe_id_seq OWNED BY public.especialidad.espe_id;
          public          tkwxxlnxscfswo    false    201            ?            1259    25844    estado_reserva    TABLE     [   CREATE TABLE public.estado_reserva (
    esre_id integer NOT NULL,
    esre_estado text
);
 "   DROP TABLE public.estado_reserva;
       public         heap    tkwxxlnxscfswo    false            ?            1259    25850    estado_reserva_esre_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.estado_reserva_esre_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.estado_reserva_esre_id_seq;
       public          tkwxxlnxscfswo    false    202            ?           0    0    estado_reserva_esre_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.estado_reserva_esre_id_seq OWNED BY public.estado_reserva.esre_id;
          public          tkwxxlnxscfswo    false    203            ?            1259    25852    medico    TABLE     ?   CREATE TABLE public.medico (
    medi_id integer NOT NULL,
    espe_id integer,
    medi_vigente boolean,
    medi_nombre text,
    medi_apellido text,
    medi_telefono text,
    medi_email text,
    medi_cedula text
);
    DROP TABLE public.medico;
       public         heap    tkwxxlnxscfswo    false            ?            1259    25858    medico_medi_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.medico_medi_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.medico_medi_id_seq;
       public          tkwxxlnxscfswo    false    204            ?           0    0    medico_medi_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.medico_medi_id_seq OWNED BY public.medico.medi_id;
          public          tkwxxlnxscfswo    false    205            ?            1259    25860    paciente    TABLE     ?   CREATE TABLE public.paciente (
    paci_id integer NOT NULL,
    paci_nombre text,
    paci_apellido text,
    paci_telefono text,
    paci_cedula text,
    paci_email text,
    paci_antecedentes text
);
    DROP TABLE public.paciente;
       public         heap    tkwxxlnxscfswo    false            ?            1259    25866    paciente_paci_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.paciente_paci_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.paciente_paci_id_seq;
       public          tkwxxlnxscfswo    false    206            ?           0    0    paciente_paci_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.paciente_paci_id_seq OWNED BY public.paciente.paci_id;
          public          tkwxxlnxscfswo    false    207            ?            1259    25868    reservacion    TABLE     ?   CREATE TABLE public.reservacion (
    rese_id integer NOT NULL,
    medi_id integer,
    paci_id integer,
    esre_id integer,
    tipa_id integer,
    rese_fecha date,
    rese_hora time without time zone,
    rese_descripcion text
);
    DROP TABLE public.reservacion;
       public         heap    tkwxxlnxscfswo    false            ?            1259    25874    reservacion_rese_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.reservacion_rese_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.reservacion_rese_id_seq;
       public          tkwxxlnxscfswo    false    208            ?           0    0    reservacion_rese_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.reservacion_rese_id_seq OWNED BY public.reservacion.rese_id;
          public          tkwxxlnxscfswo    false    209            ?            1259    25876 	   tipo_pago    TABLE     p   CREATE TABLE public.tipo_pago (
    tipa_id integer NOT NULL,
    tipa_nombre text,
    tipa_vigente boolean
);
    DROP TABLE public.tipo_pago;
       public         heap    tkwxxlnxscfswo    false            ?            1259    25882    tipo_pago_tipa_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.tipo_pago_tipa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.tipo_pago_tipa_id_seq;
       public          tkwxxlnxscfswo    false    210            ?           0    0    tipo_pago_tipa_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.tipo_pago_tipa_id_seq OWNED BY public.tipo_pago.tipa_id;
          public          tkwxxlnxscfswo    false    211            !           2604    25884    especialidad espe_id    DEFAULT     |   ALTER TABLE ONLY public.especialidad ALTER COLUMN espe_id SET DEFAULT nextval('public.especialidad_espe_id_seq'::regclass);
 C   ALTER TABLE public.especialidad ALTER COLUMN espe_id DROP DEFAULT;
       public          tkwxxlnxscfswo    false    201    200            "           2604    25885    estado_reserva esre_id    DEFAULT     ?   ALTER TABLE ONLY public.estado_reserva ALTER COLUMN esre_id SET DEFAULT nextval('public.estado_reserva_esre_id_seq'::regclass);
 E   ALTER TABLE public.estado_reserva ALTER COLUMN esre_id DROP DEFAULT;
       public          tkwxxlnxscfswo    false    203    202            #           2604    25886    medico medi_id    DEFAULT     p   ALTER TABLE ONLY public.medico ALTER COLUMN medi_id SET DEFAULT nextval('public.medico_medi_id_seq'::regclass);
 =   ALTER TABLE public.medico ALTER COLUMN medi_id DROP DEFAULT;
       public          tkwxxlnxscfswo    false    205    204            $           2604    25887    paciente paci_id    DEFAULT     t   ALTER TABLE ONLY public.paciente ALTER COLUMN paci_id SET DEFAULT nextval('public.paciente_paci_id_seq'::regclass);
 ?   ALTER TABLE public.paciente ALTER COLUMN paci_id DROP DEFAULT;
       public          tkwxxlnxscfswo    false    207    206            %           2604    25888    reservacion rese_id    DEFAULT     z   ALTER TABLE ONLY public.reservacion ALTER COLUMN rese_id SET DEFAULT nextval('public.reservacion_rese_id_seq'::regclass);
 B   ALTER TABLE public.reservacion ALTER COLUMN rese_id DROP DEFAULT;
       public          tkwxxlnxscfswo    false    209    208            &           2604    25889    tipo_pago tipa_id    DEFAULT     v   ALTER TABLE ONLY public.tipo_pago ALTER COLUMN tipa_id SET DEFAULT nextval('public.tipo_pago_tipa_id_seq'::regclass);
 @   ALTER TABLE public.tipo_pago ALTER COLUMN tipa_id DROP DEFAULT;
       public          tkwxxlnxscfswo    false    211    210            ?          0    25836    especialidad 
   TABLE DATA           W   COPY public.especialidad (espe_id, espe_nombre, espe_precio, espe_vigente) FROM stdin;
    public          tkwxxlnxscfswo    false    200   ]>       ?          0    25844    estado_reserva 
   TABLE DATA           >   COPY public.estado_reserva (esre_id, esre_estado) FROM stdin;
    public          tkwxxlnxscfswo    false    202   ?>       ?          0    25852    medico 
   TABLE DATA           ?   COPY public.medico (medi_id, espe_id, medi_vigente, medi_nombre, medi_apellido, medi_telefono, medi_email, medi_cedula) FROM stdin;
    public          tkwxxlnxscfswo    false    204   !?       ?          0    25860    paciente 
   TABLE DATA           ?   COPY public.paciente (paci_id, paci_nombre, paci_apellido, paci_telefono, paci_cedula, paci_email, paci_antecedentes) FROM stdin;
    public          tkwxxlnxscfswo    false    206   ?@       ?          0    25868    reservacion 
   TABLE DATA           {   COPY public.reservacion (rese_id, medi_id, paci_id, esre_id, tipa_id, rese_fecha, rese_hora, rese_descripcion) FROM stdin;
    public          tkwxxlnxscfswo    false    208   ?A       ?          0    25876 	   tipo_pago 
   TABLE DATA           G   COPY public.tipo_pago (tipa_id, tipa_nombre, tipa_vigente) FROM stdin;
    public          tkwxxlnxscfswo    false    210   @B       ?           0    0    especialidad_espe_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.especialidad_espe_id_seq', 11, true);
          public          tkwxxlnxscfswo    false    201            ?           0    0    estado_reserva_esre_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.estado_reserva_esre_id_seq', 8, true);
          public          tkwxxlnxscfswo    false    203            ?           0    0    medico_medi_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.medico_medi_id_seq', 19, true);
          public          tkwxxlnxscfswo    false    205            ?           0    0    paciente_paci_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.paciente_paci_id_seq', 7, true);
          public          tkwxxlnxscfswo    false    207            ?           0    0    reservacion_rese_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.reservacion_rese_id_seq', 20, true);
          public          tkwxxlnxscfswo    false    209            ?           0    0    tipo_pago_tipa_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.tipo_pago_tipa_id_seq', 95, true);
          public          tkwxxlnxscfswo    false    211            (           2606    25891    especialidad especialidad_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.especialidad
    ADD CONSTRAINT especialidad_pkey PRIMARY KEY (espe_id);
 H   ALTER TABLE ONLY public.especialidad DROP CONSTRAINT especialidad_pkey;
       public            tkwxxlnxscfswo    false    200            *           2606    25893 "   estado_reserva estado_reserva_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.estado_reserva
    ADD CONSTRAINT estado_reserva_pkey PRIMARY KEY (esre_id);
 L   ALTER TABLE ONLY public.estado_reserva DROP CONSTRAINT estado_reserva_pkey;
       public            tkwxxlnxscfswo    false    202            ,           2606    25895    medico medico_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_pkey PRIMARY KEY (medi_id);
 <   ALTER TABLE ONLY public.medico DROP CONSTRAINT medico_pkey;
       public            tkwxxlnxscfswo    false    204            .           2606    25897    paciente paciente_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (paci_id);
 @   ALTER TABLE ONLY public.paciente DROP CONSTRAINT paciente_pkey;
       public            tkwxxlnxscfswo    false    206            0           2606    25899    reservacion reservacion_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.reservacion
    ADD CONSTRAINT reservacion_pkey PRIMARY KEY (rese_id);
 F   ALTER TABLE ONLY public.reservacion DROP CONSTRAINT reservacion_pkey;
       public            tkwxxlnxscfswo    false    208            2           2606    25901    tipo_pago tipo_pago_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.tipo_pago
    ADD CONSTRAINT tipo_pago_pkey PRIMARY KEY (tipa_id);
 B   ALTER TABLE ONLY public.tipo_pago DROP CONSTRAINT tipo_pago_pkey;
       public            tkwxxlnxscfswo    false    210            3           2606    25902    medico fk_espe_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.medico
    ADD CONSTRAINT fk_espe_id FOREIGN KEY (espe_id) REFERENCES public.especialidad(espe_id) NOT VALID;
 ;   ALTER TABLE ONLY public.medico DROP CONSTRAINT fk_espe_id;
       public          tkwxxlnxscfswo    false    204    200    3880            4           2606    25907    reservacion fk_esre_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.reservacion
    ADD CONSTRAINT fk_esre_id FOREIGN KEY (esre_id) REFERENCES public.estado_reserva(esre_id) NOT VALID;
 @   ALTER TABLE ONLY public.reservacion DROP CONSTRAINT fk_esre_id;
       public          tkwxxlnxscfswo    false    3882    208    202            5           2606    25912    reservacion fk_medi_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.reservacion
    ADD CONSTRAINT fk_medi_id FOREIGN KEY (medi_id) REFERENCES public.medico(medi_id) NOT VALID;
 @   ALTER TABLE ONLY public.reservacion DROP CONSTRAINT fk_medi_id;
       public          tkwxxlnxscfswo    false    204    208    3884            6           2606    25917    reservacion fk_paci_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.reservacion
    ADD CONSTRAINT fk_paci_id FOREIGN KEY (paci_id) REFERENCES public.paciente(paci_id) NOT VALID;
 @   ALTER TABLE ONLY public.reservacion DROP CONSTRAINT fk_paci_id;
       public          tkwxxlnxscfswo    false    206    208    3886            7           2606    25922    reservacion fk_tipa_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.reservacion
    ADD CONSTRAINT fk_tipa_id FOREIGN KEY (tipa_id) REFERENCES public.tipo_pago(tipa_id) NOT VALID;
 @   ALTER TABLE ONLY public.reservacion DROP CONSTRAINT fk_tipa_id;
       public          tkwxxlnxscfswo    false    210    208    3890            ?   d   x?3?tN,J????O??6??Ȕ???Ѐ3?(?47???f?x>??HԐ?%?(SkV˙???Z???iRdę???S??Z\?????????Q???? ?%?      ?   @   x?3?tN?KN?IL??2?,J-N-*?-8S?K???T??D?Dr???y
p.s<???b???? b?!#      ?   S  x?u?Kn? ???)??b??xU?????n?M,???un?s?bb?M_b????p#?F??????i??*???]?go?????ί?N[?֡^"υ*?d?nÆh????!S??$??\?;???z=?e?P??x1'??Є??o??Q
E????MH?g0????
??8g}Of 9ՀJ*?d??R??9?ӵ??);3Pz#???fc?^|is??Z??J??P? ??`?{??m?n?X?l%?}E?~k?N3??z=Ԧ?,??;????ǥ?????&R??d????r???	<?>??TUF??f?O~??\|???'~d?)c?kE?&      ?     x?}?1N?0E??)ң????:?":??f?g?^9v????{1?*??_?z3?<z{B
???%???s?? A??4?R?t???P,??JK?|KLL?=????X??F??t?=??J?9??a?Ї֦	n??l/݂p?٧+[?j9?J???n?????͌ZZqJ?u@y?#F??M??nc??J	{^?TZ???Kq??Q^???4?S?????iz[(C?|D{??g
?????t;?w?W?]?J??˧+???`\ɒ?*?????/?XxV      ?   ?   x?e?M
1?uz?^??t??9?????	Z?th/????(?Vo?%??@-@%-l????	??3??Rf}?98}??i'+gE#P??_?,?+??ݕ?.i???\y?aq><?,??ߙ???D?S?t/ Jy|?(?^	40I      ?   H   x??4?H?,H??,?2?L.:?2%?$?1?LMKM.?,q,M8C??RK9Ӹ,?9?2K??3???=... ??G     