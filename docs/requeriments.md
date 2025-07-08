# Épicos e Histórias de Usuário – Mural de Caronas Universitárias

---

## EPIC-01: Gestão de Usuários

| Atributo             | Valor                                                   |
| :------------------- | :------------------------------------------------------- |
| **ID do Épico**      | EPIC-01                                                 |
| **Persona Principal**| Usuário (Motorista, Passageiro ou Administrador)        |

### Descrição  
Este épico cobre todo o fluxo de **cadastro**, **login** e **manutenção** de perfis na plataforma. Inclui tanto usuários comuns (que podem atuar como passageiro e motorista) quanto administradores, garantindo gravação segura de credenciais e controle de acesso.

### Escopo e Funcionalidades Principais  
- **Cadastro de Usuário:** formulário de criação de conta com validação de e-mail e senha.  
- **Autenticação/Login:** login/logout seguro, com hashing de senha.  
- **Edição de Perfil:** atualização de dados pessoais e, no caso de motorista, dados do veículo.  
- **Recuperação de Senha:** fluxo de reset via e-mail.  

### 📜 Histórias de Usuário  
- **HU01:** Como **Visitante**, quero **cadastrar conta** para poder acessar as funcionalidades da plataforma.  
- **HU02:** Como **Usuário**, quero **fazer login/logout**, para proteger meus dados e continuar minhas sessões.  
- **HU03:** Como **Usuário**, quero **editar meu perfil** (dados pessoais e, se motorista, veículo), para manter minhas informações atualizadas.  
- **HU04:** Como **Usuário**, quero **recuperar senha** via e-mail, para caso eu esqueça minhas credenciais.  

### 🚀 Requisitos Não-Funcionais Chave  
- **Segurança:** senhas armazenadas com hashing (bcrypt ou similar).  
- **Usabilidade:** mensagens de erro claras em formulários.  
- **Performance:** autenticação em menos de 500 ms.  

### ✅ Critérios de Aceite  
- [ ] Formulário de cadastro aceita e-mail e senha válidos, e impede duplicatas.  
- [ ] Fluxo de login retorna token de sessão ou cookie seguro.  
- [ ] Usuário autenticado consegue acessar página de edição e salvar alterações.  
- [ ] Recuperação de senha envia e-mail com link de redefinição válido por 1 hora.  

---

## EPIC-02: Oferta e Busca de Caronas

| Atributo             | Valor                         |
| :------------------- | :---------------------------- |
| **ID do Épico**      | EPIC-02                       |
| **Persona Principal**| Motorista e Passageiro       |

### Descrição  
Permite que motoristas **ofertem** caronas definindo rota, data/hora, campus e vagas, e que passageiros **busquem** essas ofertas por filtros de rota, horário e campus.

### Escopo e Funcionalidades Principais  
- **Criar Carona:** formulário para informar origem, destino, dataHora e vagas (até 4).  
- **Listar Caronas Disponíveis:** exibir todas as ofertas ativas.  
- **Filtros de Busca:** filtrar por rota (origem/destino), dataHora e campus.  
- **Detalhes da Carona:** visualizar informações completas da oferta antes de solicitar reserva.  

### 📜 Histórias de Usuário  
- **HU05:** Como **Motorista**, quero **oferecer uma nova carona** informando rota, data/hora, campus e vagas, para disponibilizá-la na plataforma.  
- **HU06:** Como **Passageiro**, quero **ver a lista de caronas disponíveis**, para escolher uma viagem que me atenda.  
- **HU07:** Como **Passageiro**, quero **filtrar caronas por origem, destino, data/hora e campus**, para encontrar apenas ofertas compatíveis.  
- **HU08:** Como **Passageiro**, quero **ver os detalhes de uma carona selecionada**, para decidir se faço a reserva.  

### 🚀 Requisitos Não-Funcionais Chave  
- **Responsividade:** listagem e filtros devem funcionar bem em mobile e desktop.  
- **Reatividade:** ao aplicar filtros, a lista deve atualizar em < 1 s.  

### ✅ Critérios de Aceite  
- [ ] Motorista consegue criar carona e vê-la imediatamente na listagem.  
- [ ] Passageiro vê apenas caronas ativas (status = “disponível”).  
- [ ] Filtros combinados (origem + destino + dataHora + campus) retornam resultados corretos.  
- [ ] Detalhes exibem todos os atributos da carona e número de vagas restantes.  

---

## EPIC-03: Reserva de Vaga

| Atributo             | Valor                         |
| :------------------- | :---------------------------- |
| **ID do Épico**      | EPIC-03                       |
| **Persona Principal**| Passageiro                   |

### Descrição  
Permite que passageiros **reservem** vagas em caronas disponíveis, e que motoristas **confirmem** ou **cancelem** essas reservas.

### Escopo e Funcionalidades Principais  
- **Solicitar Reserva:** passageiro envia pedido de reserva de vaga.  
- **Gerenciar Reserva:** motorista aprova ou recusa solicitações.  
- **Cancelar Reserva:** passageiro pode desistir de uma vaga antes da viagem.  
- **Atualização de Vagas:** sistema ajusta automaticamente as vagas disponíveis após confirmação ou cancelamento.  

### 📜 Histórias de Usuário  
- **HU09:** Como **Passageiro**, quero **reservar uma vaga** em uma carona, para garantir meu lugar.  
- **HU10:** Como **Motorista**, quero **ver e confirmar/recusar reservas pendentes**, para controlar quem vai viajar.  
- **HU11:** Como **Passageiro**, quero **cancelar minha reserva** antes da carona, para liberar a vaga.  

### 🚀 Requisitos Não-Funcionais Chave  
- **Consistência:** número de vagas nunca deve ficar negativo.  
- **Notificações:** e-mail ou in-app alertando passageiro/motorista sobre mudança de status.  

### ✅ Critérios de Aceite  
- [ ] Pedido de reserva gera entry com status “pendente”.  
- [ ] Motorista recebe lista de reservas pendentes e consegue aprovar/recusar.  
- [ ] Ao aprovar, vagas são decrementadas; ao recusar ou cancelar, vagas são incrementadas.  
- [ ] Passageiro é notificado sobre o status da reserva.  

---

## EPIC-04: Avaliação e Feedback

| Atributo             | Valor                             |
| :------------------- | :-------------------------------- |
| **ID do Épico**      | EPIC-04                           |
| **Persona Principal**| Passageiro e Motorista           |

### Descrição  
Após cada carona, tanto **passageiros** quanto **motoristas** podem avaliar mutuamente a experiência, gerando confiança na comunidade.

### Escopo e Funcionalidades Principais  
- **Deixar Avaliação:** formulário com nota (1–5) e comentário.  
- **Ver Histórico de Avaliações:** cada perfil exibe avaliações recebidas.  
- **Média de Avaliações:** cálculo automático de rating médio no perfil do usuário.  

### 📜 Histórias de Usuário  
- **HU12:** Como **Passageiro**, quero **avaliar o motorista** ao fim da viagem, para registrar minha satisfação.  
- **HU13:** Como **Motorista**, quero **avaliar cada passageiro** ao fim da viagem, para dar feedback.  
- **HU14:** Como **Visitante**, quero **ver a média de avaliações** de um usuário (motorista ou passageiro), para ter confiança.  

### 🚀 Requisitos Não-Funcionais Chave  
- **Imutabilidade:** avaliações não podem ser editadas após envio, apenas reportadas.  
- **Performance:** cálculo de média em tempo real deve ser rápido (cacheável, se necessário).  

### ✅ Critérios de Aceite  
- [ ] Após confirmação de carona, usuários recebem convite para avaliar.  
- [ ] Avaliação salva nota e comentário associados ao autor, destinatário e à carona.  
- [ ] Média de notas é exibida no perfil e atualizada automaticamente.  
- [ ] Avaliações aparecem em ordem cronológica no histórico.  

---

## EPIC-05: Moderação e Administração

| Atributo             | Valor                         |
| :------------------- | :---------------------------- |
| **ID do Épico**      | EPIC-05                       |
| **Persona Principal**| Administrador                |

### Descrição  
Permite ao administrador **monitorar** e **manter a saúde** da comunidade, banindo usuários, removendo avaliações indevidas e aprovando novos motoristas.

### Escopo e Funcionalidades Principais  
- **Aprovar Motorista:** validação de documentos e habilitação.  
- **Banir Usuário:** bloquear acesso e ocultar publicações.  
- **Remover Feedback:** excluir avaliações consideradas abusivas.  
- **Visualizar Relatórios:** painel com estatísticas de uso e indicadores (reservas, avaliações, cadastros).  

### 📜 Histórias de Usuário  
- **HU15:** Como **Administrador**, quero **aprovar ou rejeitar solicitações de novos motoristas**, para garantir a qualidade das caronas.  
- **HU16:** Como **Administrador**, quero **banir usuários infratores**, para manter a comunidade segura.  
- **HU17:** Como **Administrador**, quero **remover avaliações reportadas**, para evitar abusos.  
- **HU18:** Como **Administrador**, quero **ver relatórios gerenciais** (reservas, avaliações, cadastros), para monitorar a operação.  

### 🚀 Requisitos Não-Funcionais Chave  
- **Segurança:** somente usuários com perfil admin podem acessar essas funções.  
- **Auditoria:** cada ação (banir, remover feedback) deve ser logada com data, hora e admin responsável.  

### ✅ Critérios de Aceite  
- [ ] Painel de moderação acessível apenas a administradores.  
- [ ] Aprovação de motoristas altera perfil e permite oferta de carona.  
- [ ] Banimento revoga tokens de sessão e oculta perfil/carona do banido.  
- [ ] Relatórios exportáveis em CSV.  
