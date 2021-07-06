-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema test_project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema test_project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `test_project` DEFAULT CHARACTER SET utf8 ;
USE `test_project` ;

-- -----------------------------------------------------
-- Table `test_project`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`roles` (
  `id` BIGINT(20) NOT NULL,
  `name` CHAR(5) NOT NULL,
  `created_at` DATE NULL,
  `updated_at` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`users` (
  `id` BIGINT(20) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `gender` ENUM('мужской', 'женский') NOT NULL,
  `city` VARCHAR(45) NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NULL,
  `role_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_roles1`
    FOREIGN KEY (`role_id`)
    REFERENCES `test_project`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`categories` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(15) NOT NULL,
  `categories_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_categories_categories1`
    FOREIGN KEY (`categories_id`)
    REFERENCES `test_project`.`categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`groups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`groups` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NULL,
  `image_link` VARCHAR(45) NULL,
  `admin_id` INT NOT NULL,
  `created_at` DATE NOT NULL,
  `updated_at` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`friend_invite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`friend_invite` (
  `id` BIGINT(20) NOT NULL,
  `user_from_id` BIGINT(20) NOT NULL,
  `user_to_id` DATETIME NOT NULL,
  `created_at` DATETIME NULL,
  `status` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_friend_invite_users1`
    FOREIGN KEY (`user_from_id`)
    REFERENCES `test_project`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`group_invite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`group_invite` (
  `id` BIGINT(20) NOT NULL,
  `user_from_id` BIGINT(20) NOT NULL,
  `user_to_id` BIGINT(20) NOT NULL,
  `target_group_id` BIGINT(20) NOT NULL,
  `created_at` DATETIME NULL,
  `status` VARCHAR(10) NOT NULL,
  `groups_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`, `groups_id`),
  CONSTRAINT `fk_group_invite_users1`
    FOREIGN KEY (`user_from_id`)
    REFERENCES `test_project`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_group_invite_groups1`
    FOREIGN KEY (`groups_id`)
    REFERENCES `test_project`.`groups` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`users_groups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`users_groups` (
  `user_id` BIGINT(20) NOT NULL,
  `group_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`user_id`, `group_id`),
  CONSTRAINT `fk_users_groups_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `test_project`.`users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_users_groups_groups1`
    FOREIGN KEY (`group_id`)
    REFERENCES `test_project`.`groups` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`users_friends`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`users_friends` (
  `user_id` BIGINT(20) NOT NULL,
  `friend_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`user_id`, `friend_id`),
  CONSTRAINT `fk_users_friends_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `test_project`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_friends_users2`
    FOREIGN KEY (`friend_id`)
    REFERENCES `test_project`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`products` (
  `id` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NULL,
  `desctiption` VARCHAR(60) NOT NULL,
  `image_link` VARCHAR(45) NULL,
  `price` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  CONSTRAINT `fk_products_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `test_project`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`grant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`grant` (
  `id` BIGINT(20) NOT NULL,
  `name` CHAR(10) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`roles_grants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`roles_grants` (
  `role_id` BIGINT(20) NOT NULL,
  `grant_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`role_id`, `grant_id`),
  CONSTRAINT `fk_roles_has_table1_roles1`
    FOREIGN KEY (`role_id`)
    REFERENCES `test_project`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_roles_has_table1_table11`
    FOREIGN KEY (`grant_id`)
    REFERENCES `test_project`.`grant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`posts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`posts` (
  `id` BIGINT(20) NOT NULL,
  `content` VARCHAR(150) NOT NULL,
  `file_link` VARCHAR(50) NULL,
  `author_id` BIGINT(20) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NULL,
  `category_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`, `category_id`),
  CONSTRAINT `fk_posts_users1`
    FOREIGN KEY (`author_id`)
    REFERENCES `test_project`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_posts_categories1`
    FOREIGN KEY (`category_id`)
    REFERENCES `test_project`.`categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`comments` (
  `id` BIGINT(20) NOT NULL,
  `content` VARCHAR(150) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `parent_comment_id` BIGINT(20) NOT NULL,
  `author_id` BIGINT(20) NOT NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_comments_users2`
    FOREIGN KEY (`author_id`)
    REFERENCES `test_project`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_comments1`
    FOREIGN KEY (`parent_comment_id`)
    REFERENCES `test_project`.`comments` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_project`.`messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_project`.`messages` (
  `id` BIGINT(20) NOT NULL,
  `content` VARCHAR(200) NOT NULL,
  `user_from_id` BIGINT(20) NOT NULL,
  `user_to_id` BIGINT(20) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_messages_users1`
    FOREIGN KEY (`user_from_id`)
    REFERENCES `test_project`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
