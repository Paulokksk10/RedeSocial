# RedeSocial
# Resumo Descritivo da Aplicação da Rede Social:

A aplicação de rede social é um sistema que permite que os usuários se conectem, compartilhem informações e interajam entre si. Ela é composta por diversas entidades e relacionamentos para fornecer uma plataforma de mídia social completa. Abaixo está um resumo descritivo das principais entidades e seus relacionamentos na aplicação da rede social:

# Diagrama

![redeSocial](https://github.com/Paulokksk10/RedeSocial/assets/109988092/dd23dbf9-f1ab-49d4-9a19-99e4c125551f)

# Protótipo da Aplicação

[Figma](https://www.figma.com/file/dTqYSFX5mb93YpqZgrjOEq/Rede-Social?type=design&node-id=2%3A8&mode=design&t=0GyzlOC59ztHaPMT-1&authuser=0)



# 1. Entidade Rede Social:

- Representa a própria rede social.

- Contém listas de usuários, postagens e amizades.

  

# 2. Entidade Usuário:

- Armazena informações sobre os usuários da rede social, como nome, data de nascimento, email, foto de perfil, biografia, entre outros.

- Possui relacionamentos:

- Lista de amigos (representados pela entidade "Amizade").

- Lista de postagens (representadas pela entidade "Publicação").

- Lista de amizades (representadas pela entidade "Amizade").

  

# 3. Entidade Publicação:

- Representa as postagens compartilhadas pelos usuários.

- Armazena informações como conteúdo da postagem, data de publicação e localização.

- Possui relacionamentos:

- Autor da publicação (referenciando a entidade "Usuário").

- Lista de curtidas (representadas pela entidade "Curtida").

- Lista de comentários (representadas pela entidade "Comentário").

  

# 4. Entidade Curtida:

- Registra as curtidas dadas pelos usuários em postagens.

- Armazena informações como data da curtida.

- Possui relacionamentos:

- Usuário que deu a curtida (referenciando a entidade "Usuário").

- Publicação curtida (referenciando a entidade "Publicação").

  

# 5. Entidade Amizade:

- Representa as conexões de amizade entre os usuários.

- Armazena informações como a data em que a amizade foi estabelecida.

- Possui relacionamentos:

- Usuário 1 (referenciando a entidade "Usuário").

- Usuário 2 (referenciando a entidade "Usuário").


> Essas entidades e relacionamentos formam a estrutura básica de uma rede social, permitindo que os usuários se conectem, compartilhem postagens, expressem curtidas e estabeleçam amizades. A aplicação da rede social proporciona uma plataforma interativa para comunicação e compartilhamento de conteúdo entre seus membros.

