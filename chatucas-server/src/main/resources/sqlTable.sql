CREATE TABLE users (
                       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       password_digest VARCHAR(255) NOT NULL,
                       created_at DATETIME(6) NOT NULL,
                       updated_at DATETIME(6) NOT NULL,
                       UNIQUE (username)
);

CREATE TABLE conversations (
                               id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                               created_at DATETIME(6) NOT NULL,
                               updated_at DATETIME(6) NOT NULL,
                               user_id INT NOT NULL,
                               CONSTRAINT fk_rails_7c15d62a0a FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE INDEX index_conversations_on_user_id ON conversations(user_id);

CREATE TABLE messages (
                          id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          user VARCHAR(255),
                          text VARCHAR(255),
                          conversation_id INT NOT NULL,
                          created_at DATETIME(6) NOT NULL,
                          updated_at DATETIME(6) NOT NULL,
                          user_id INT,
                          CONSTRAINT fk_rails_7f927086d2 FOREIGN KEY (conversation_id) REFERENCES conversations(id),
                          CONSTRAINT fk_rails_273a25a7a6 FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE INDEX index_messages_on_conversation_id ON messages(conversation_id);