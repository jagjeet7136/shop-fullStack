import React from "react";
import styles from "./Navbar.module.css";
import logo from "../../images/logo-transparent-png.png";
import '@fortawesome/fontawesome-free/css/all.min.css';
import { Link } from "react-router-dom";

export const Navbar = () => {
    return (
        <nav>
            <div className={styles.nav}>
                <div className={styles.logoSearchContainer}>
                    <a href="/" className={styles.logo}><img src={logo} alt="logo" /></a>
                    <div className={styles.search}>
                        <input type="text" placeholder="Search..." />
                        <Link><i className="fa fa-search"></i></Link>
                    </div>
                </div>
                <div className={styles.cartAccountContainer}>
                    <Link className={styles.account}>
                        <i className="fa fa-search"></i>
                        <span>Account</span>
                    </Link>
                    <Link className={styles.cart}>
                        <div className={styles.cartLogoContainer}>
                            <i className="fa fa-shopping-cart"></i>
                        </div>
                        <span>Cart</span>
                    </Link>
                </div>
            </div>
            <div className={styles.secondarySearch}>
                <input type="text" placeholder="Search..." />
                <Link><i className="fa fa-search"></i></Link>
            </div>
        </nav>
    );
};