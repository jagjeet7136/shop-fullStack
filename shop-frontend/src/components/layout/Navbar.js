import React from "react";
import styles from "./Navbar.module.css";
import logoImage from "../../images/logo-transparent-png.png";

export const Navbar = () => {
    return (
        <nav>
            <div className={styles.logoSearchContainer}>
                <a href="/"><img src={logoImage} alt="logo" /></a>
                <div className={styles.searchContainer}>
                    <input type="text" placeholder="Search..." />
                    <button type="submit"><i class="fa fa-search"></i></button>
                </div>
            </div>

            <div className={styles.navbar}>
                <a href="/">Cart</a>
                <a href="/">Account</a>
            </div>
        </nav>);
};