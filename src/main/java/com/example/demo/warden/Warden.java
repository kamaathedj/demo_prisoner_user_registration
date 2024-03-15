package com.example.demo.warden;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "warden")
public class Warden{
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id int id ;
        String name;
        String password;
        int number_of_prisoner;
        boolean is_admin;

        public Warden(int id, String name, String password, int numberOfPrisoner, boolean isAdmin) {
                this.id = id;
                this.name = name;
                this.password = password;
                number_of_prisoner = numberOfPrisoner;
                this.is_admin = isAdmin;
        }

        public Warden() {

        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public int getNumber_of_prisoners() {
                return number_of_prisoner;
        }

        public void setNumber_of_prisoners(int number_of_prisoners) {
                this.number_of_prisoner = number_of_prisoners;
        }

        public boolean isIs_admin() {
                return is_admin;
        }

        public void setIs_admin(boolean is_admin) {
                this.is_admin = is_admin;
        }

        @Override
        public String  toString() {
                return "Warden{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", password='" + password + '\'' +
                        ", NumberOfPrisoner=" + number_of_prisoner +
                        ", isAdmin=" + is_admin +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Warden warden = (Warden) o;
                return id == warden.id && number_of_prisoner == warden.number_of_prisoner && is_admin == warden.is_admin && Objects.equals(name, warden.name) && Objects.equals(password, warden.password);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, password, number_of_prisoner, is_admin);
        }
}


