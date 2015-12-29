# 目的
Webアプリケーションを早く開発するために、Javaフレームワークセットのテンプレートと基本的な使い方を実装しておき、それを元に開発するためのテンプレートになります。いろいろな選択がありますが、今回は以下のフレームワークを利用しています。

+ SpringMVC
+ Thymeleaf
+ Doma2

[![Build Status](https://travis-ci.org/takayasu/webtemplate.svg)](https://travis-ci.org/takayasu/webtemplate)

# 設定ファイル
設定ファイルはweb.xmlから追っていていけばわかるとは思いますが、以下のファイルが設定になっています。

+ src/main/webapp/WEB-INF/web.xml
+ src/main/webapp/WEB-INF/spring/application.xml
+ src/main/resources/application.properties

（Springのscanはcom.yurugee.tech.webより下に設定してあります）

# テンプレートファイル
Thymeleafのテンプレートファイルは、
src/main/webapp/WEB-INF/templates
に配置するように設定しています。

# ビルドファイル
Gradleを使っています。
+ build.gradle

を確認してください。

# システム環境
+ Java8が必須になっています。（Doma2の制約）
+ Gradleを利用しています。
+ PostgreSQLを利用しています。

# 利用方法
## Eclipse 環境
このリポジトリをclone してください。
その後、以下のコマンドでEclipse環境を生成します。

~~~~
gradle eclipse
~~~~

その後、インポート>既存プロジェクトをワークスペースへ
を利用して、プロジェクトを作成します。

## Eclipse設定

### GradleHomeの設定
ビルドパスにおいて変数として、Gradleのホームを設定する必要があります。

GRADLE_USER_HOMEをユーザの.gradleフォルダを設定してください。


### 注釈処理の設定
このプログラムはDoma2を使っているため、APTの設定をする必要があります。


#### 注釈処理
プロジェクトのプロパティからJavaコンパイラ＞注釈を選択して、
注釈処理を使用可能にするにチェックを入れます。
フォルダをaptにしてください。
（この設定をする前は、BuildPath上のエラーがでていると思います。このフォルダをClasspath（ソースフォルダ）としてGradleで設定しているため、起こっています。設定をするとビルドエラーが消えます。）

#### ファクトリパス
domaのJARを設置して、JAVAのファクトリを利用しないにします。
（domaのJARはGradleのcacheフォルダ以下にあります。）

### Domaツールの設定
SQLファイルとの開発を楽にするために、Domaツールの導入をお勧めします。

http://doma.readthedocs.org/ja/stable/getting-started/#eclipse-doma-tools


### DB環境

#### 設定
デフォルトはローカル環境で設定してあるので、application.propertiesで接続先を変更してください。

+ datasource.app.url
+ datasource.app.username
+ datasource.app.password

#### サンプルを動作するためのSQL
src/main/sql/emp.sql を対象データベースで実行してください。

## サンプルで定義されている処理

+ コンテキスト名/ IndexController#index

  index.htmlテンプレートが呼び出されるだけです。
　　表示された画面の
　　　　最初のテキストボックスにID
　　　　次のテキストボックスにname
　　情報を入力と登録されます。（バリデーションしてません）

+ コンテキスト名/test/index TestController#index

  empテーブルの登録済みのID=1の情報を表示する。

+ コンテキスト名/test/list TestController#list

  empテーブルの登録済み情報を表示する。

+ コンテキスト名/test/add TestController#add
　
　　empテーブルに挿入する。





