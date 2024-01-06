# Java Discord Bot Template
This is the base code that I use that appears in all the bots that I've created. This includes [Animal Crossing Bot](http://angelolz.dev/acbot) 
and [Wordie](http://angelolz.dev/wordie).

This bot template includes slash commands support, database setup and text/slash command tracking functions as well.

# Dependencies
This project comes with a few dependencies that will aid in the development of the Discord bot.

- JDA *(Discord API wrapper)*
- JDA-Chewtils *(Extensions to JDA that adds support for command cooldowns, slash commands, etc.)*
- logback-classic + others *(logging)*
- HikariCP + mysql-connector-java *(database stuff)*
## Before Running...

- Remove the `.example` part in the `bot.properties.example` file. Fill in the required fields:
  - `bot_token` - Token used for the bot to login. You can get this in your [developer dashboard](https://discord.com/developers/applications).
  - `owner_id` - Typically, this would be your Discord ID.
  - `log_channel_id` - This is where any log messages you put will be sent here.
  - `exception_channel_id` - This is where any errors you log will be sent. This can be the same id as the `log_channel_id`.
  - `testing_guild_id` - This is where your slash commands will be applied to when testing them.
- Remove the `.example` part in the `db.properties.example` file. Fill in the required fields:
  - Change the `DATABASE_NAME_HERE` part to your database name in the URL.
  - Put your username and password.
  - **If you don't need a database, you can delete the `DatabaseManager.init()` line in `DiscordBot.java`.**