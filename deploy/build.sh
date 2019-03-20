#!/usr/bin/env bash
source ${1}/_functions.sh --vendor
[[ -z ${2:-""} ]] || cd $2

set -a
source .env
set +a

export APP_VERSION=$(versionFromGit)
export APP_PORT=${APP_PORT:-8002}

export APP_PROD=${APP_PROD:-true}
export ADSERVER_URL=${ADSERVER_URL:-${ADSERVER_URL_FROM_CMD}}
export DEV_XDEBUG=${DEV_XDEBUG:-false}
export APP_ENV=${APP_ENV:-prod}

envsubst < src/environments/environment.ts.template | tee src/environments/environment.${APP_ENV}.ts

yarn install

if [[ ${APP_ENV} == 'dev' ]]
then
    yarn build
elif [[ ${APP_ENV} == 'prod' ]]
then
    yarn build --prod
else
    echo "ERROR: Unsupported environment ($APP_ENV)."
    exit 1
fi

test -f info.json.template && envsubst < info.json.template | tee dist/info.json